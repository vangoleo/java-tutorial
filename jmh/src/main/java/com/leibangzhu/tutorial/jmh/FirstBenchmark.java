package com.leibangzhu.tutorial.jmh;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class FirstBenchmark {

    @Benchmark
    public void sleep(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) throws Exception{

        Options opt = new OptionsBuilder()
                .include(FirstBenchmark.class.getSimpleName())
                .forks(1)                       // fork出几个进程来进行测试
                .warmupIterations(5)            // 预热的迭代次数
                .measurementIterations(5)       // 实际测量的迭代次数
                .build();

        new Runner(opt).run();
    }
}

