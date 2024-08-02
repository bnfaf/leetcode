package org.example;

public class s1411 {
    static final int MOD = 1000000007;
    public int numOfWays(int n) {
        long f0 = 6, f1 = 6;
        for (int i = 2;i<=n;i++){
            long newF0 = (2*f0+2*f1)% MOD;
            long newF1 = (2*f0 + 3*f1) % MOD;
            f0 = newF0;
            f1 = newF1;
        }
        return (int)((f0+f1)%MOD);
    }


    public static void main(String[] args) {
        s1411 solution = new s1411();
        System.out.println(solution.numOfWays(2));
    }

}
