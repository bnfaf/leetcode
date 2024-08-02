package org.example;

import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

import java.util.Arrays;

public class s1049 {
    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target+1];
        for (int store : stones){
            for (int j = target; j >= store; j--){
                dp[j] = Math.max(dp[j], dp[j-store]+store);
            }
        }
        return sum - 2 * dp[target];
    }

    public static void main(String[] args) {
        int[] stores = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stores));
    }
}
