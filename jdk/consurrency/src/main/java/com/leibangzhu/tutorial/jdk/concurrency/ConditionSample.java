package com.leibangzhu.tutorial.jdk.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSample {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();     // 获取锁,如果锁已被占用，一直等待
                    System.out.println("wait for a new signal" + this);
                    // 当前线程释放锁，将自己sleep，等待唤醒。
                    // 当其他线程调用condition.signal时,当前线程会会唤醒，并且重新尝试获得锁。如果获取不到锁，会一直等待。
                    condition.await();
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("Get a signal" + this);
                lock.unlock();
            }
        },"waitThread");

        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("Get a lock");
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                // 调用condition.signal()会让await的线程被唤醒。
                // 并在从await方法返回之前，会去重新获得锁。
                condition.signalAll();
                System.out.println("Send a signal");
                System.out.println("b start to release lock");
                lock.unlock();
                System.out.println("b already released lock");
            }
        },"signThread");

        thread1.start();
    }
}