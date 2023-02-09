package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    public static volatile AtomicInteger race = new AtomicInteger(0);
    private static final int THREADS_COUNT = 20;

    public static  void increase(){
        race.getAndIncrement();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        increase();
                    }
                    System.out.println("race="+race);
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
