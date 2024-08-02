package org.example;

import java.util.Arrays;

public class BagProblem {

    public static void testWeightBagProblem(int[] weight, int[] value, int bagsize){
        int goods = weight.length;
        int[] dp = new int[bagsize+1];
        for (int i = 0; i < goods; i++) {
            for (int j = bagsize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }
}
