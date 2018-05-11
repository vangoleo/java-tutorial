package com.leibangzhu.tutorial.jdk.concurrency;

public class ThreadLocalSample {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable work = new MyRunnable();

        Thread thread1 = new Thread(work);
        Thread thread2 = new Thread(work);
        Thread thread3 = new Thread(work);

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000 * 10);

    }

    public static class MyRunnable implements Runnable {

        private Integer local = (int) (Math.random() * 100);
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100));

            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }

            System.out.println("Local:" + local);
            System.out.println("ThreadLocal:" + threadLocal.get());
        }
    }
}
// Local:60
// Local:60
// ThreadLocal:82
// Local:60
// ThreadLocal:45
// ThreadLocal:99