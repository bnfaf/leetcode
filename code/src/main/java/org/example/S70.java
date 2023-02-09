package org.example;

public class S70 {
    public int climbStairs(int n) {
        int a = 1, b = 2, tmp;
        if (n == 1){
            return n;
        }
        for (int i = 3; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
