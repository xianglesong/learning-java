package com.xianglesong.basic.concurrent.future;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by rollin on 18/4/3.
 */
public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> f1 = executor.submit(new Worker("one"));
        Future<String> f2 = executor.submit(new Worker("two"));

        Future<String> f3 = executor.submit(new Worker("three"));

        try {
            String r1 = f1.get();
            System.out.println("r1: " + r1 + " " + System.currentTimeMillis());

            String r2 = f2.get();
            System.out.println("r2: " + r2 + " " + System.currentTimeMillis());

            String r3 = f3.get(1, TimeUnit.SECONDS);
            System.out.println("r3: " + r3 + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("end");

        executor.shutdownNow();
        executor.shutdown();
    }

}

class Worker implements Callable<String> {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        String result = "begin: " + System.currentTimeMillis();
        Thread.sleep(3000);
        String end = "end: " + System.currentTimeMillis();
        System.out.println(Thread.currentThread() + " " + result + " and name: " + name);
        System.out.println(Thread.currentThread() + " " + end + " and name: " + name);
        return result;
    }
}








