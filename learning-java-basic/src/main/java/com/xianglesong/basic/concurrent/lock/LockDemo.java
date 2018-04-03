package com.xianglesong.basic.concurrent.lock;

/**
 * Created by rollin on 18/4/3.
 */

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private final ReentrantLock lock;

    public LockDemo() {
        lock = new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        final LockDemo lockDemo = new LockDemo();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                lockDemo.lock.lock();
//                System.out.println(String.format("%s %s locked", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
//            }
//        };

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                if (lockDemo.lock.tryLock()) {
//                    System.out.println(String.format("%s %s locked", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
//                }
//            }
//        };
//
//
//        Thread threadA = new Thread(runnable, "Thread A");
//        Thread threadB = new Thread(runnable, "Thread B");
//        threadA.start();
//        threadB.start();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    lockDemo.lock.lockInterruptibly();
                    System.out.println(String.format("%s %s locked", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
                } catch (InterruptedException e) {
                    System.out.println(String.format("%s %s interrupted", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
                }
            }
        };

        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        threadB.interrupt();
    }
}
