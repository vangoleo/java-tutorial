package com.leibangzhu.tutorial.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class SecondBenchmark {

    @Param({"10000","100000","1000000"})
    private int length;

    private int[] numbers;
    private Calculator singleThreadCalc;
    private Calculator multiThreadCalc;

    private interface Calculator{
        long sum(int[] numbers);
        void shutdown();
    }

    @Benchmark
    public long singleThreadBenchmark(){
        return singleThreadCalc.sum(numbers);
    }

    @Benchmark
    public long multiThreadBenchmark(){
        return multiThreadCalc.sum(numbers);
    }

    @Setup
    public void prepare(){
        numbers = IntStream.rangeClosed(1,length).toArray();
        singleThreadCalc = new SingleThreadCalculator();
        multiThreadCalc = new MultiThreadCalculator(Runtime.getRuntime().availableProcessors());
    }

    @TearDown
    public void shutdown(){
        singleThreadCalc.shutdown();
        multiThreadCalc.shutdown();
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(SecondBenchmark.class.getSimpleName())
                .forks(2)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(options).run();
    }

    private static class SingleThreadCalculator implements Calculator{

        @Override
        public long sum(int[] numbers) {
            long total = 0L;

            for (int i: numbers){
                total += i;
            }

            return total;
        }

        @Override
        public void shutdown() {

        }
    }

    private static class MultiThreadCalculator implements Calculator{

        private final int nThreads;
        private final ExecutorService pool;

        public MultiThreadCalculator(int nThreads){
            this.nThreads = nThreads;
            this.pool = Executors.newFixedThreadPool(nThreads);
        }

        @Override
        public long sum(int[] numbers) {
            int chunk = numbers.length / nThreads;

            int from, to;
            List<SumTask> tasks = new ArrayList<SumTask>();
            for (int i = 1; i <= nThreads; i++) {
                if (i == nThreads) {
                    from = (i - 1) * chunk;
                    to = numbers.length;
                } else {
                    from = (i - 1) * chunk;
                    to = i * chunk;
                }
                tasks.add(new SumTask(numbers, from, to));
            }

            try {
                List<Future<Long>> futures = pool.invokeAll(tasks);

                long total = 0L;
                for (Future<Long> future : futures) {
                    total += future.get();
                }
                return total;
            } catch (Exception e) {
                // ignore
                return 0;
            }
        }

        @Override
        public void shutdown() {
            pool.shutdown();
        }
    }

    private static class SumTask implements Callable<Long> {
        private int[] numbers;
        private int from;
        private int to;

        public SumTask(int[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        public Long call() throws Exception {
            long total = 0L;
            for (int i = from; i < to; i++) {
                total += numbers[i];
            }
            return total;
        }
    }

}
