package org.example;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadLocalExample implements Runnable{


    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
    private static int index = 0;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        ThreadLocalExample obj = new ThreadLocalExample();
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0 ; i<10; i++){
            threadPool.execute(()->{
                try {
                    Thread t = new Thread(obj, ""+index++);
                    t.start();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println(1);
        System.out.println(formatter);


    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads

        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
        formatter.remove();
    }

}

