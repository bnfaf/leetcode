package org.example;

public class offer62 {
    public int lastRemaining(int n, int m) {
        if (n == 1){
            return 0;
        }
        int x = lastRemaining(n-1, m);
        return (m + x) % n;
    }

    public static void main(String[] args) {
        offer62 solution = new offer62();
        System.out.println(solution.lastRemaining(10, 17));
    }
}
