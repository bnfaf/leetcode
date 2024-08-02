package org.offer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ThreadDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> odd = new ArrayBlockingQueue<>(1);
        BlockingQueue<Integer> even = new ArrayBlockingQueue<>(1);
        Thread thread1 = new Thread(()->{
            for (int i = 0; i< 5; i++){
                try {
                    odd.put(1);
                    System.out.println(2*i);
                    even.put(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i< 5; i++){
                try {
                    even.take();
                    System.out.println(2*i+1);
                    odd.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }


}
