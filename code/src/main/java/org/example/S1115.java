package org.example;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class S1115 {
    private int n;
   private BlockingDeque<Integer> bar = new LinkedBlockingDeque<>(1);
   private BlockingDeque<Integer> foo = new LinkedBlockingDeque<>(1);
    public S1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.put(1);
            printFoo.run();
            bar.put(1);
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
           bar.take();
           printBar.run();
           foo.take();
            // printBar.run() outputs "bar". Do not change or remove this line.

        }
    }
}
