package org.example;

public class s509 {
    public int fib(int n) {
        if (n <= 1){
            return n;
        }
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
