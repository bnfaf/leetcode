package org.example;

public class offer10I {
    public int fib(int n) {
        if (n < 2){
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c =  (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }
}
