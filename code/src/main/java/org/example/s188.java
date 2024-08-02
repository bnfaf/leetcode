package org.example;

import org.openjdk.jol.vm.VM;

import java.util.*;
import java.util.stream.Collectors;

public class s188 {
    public int maxProfit(int k, int[] prices) {
        // 奇数 持有 偶数 未持有
        int len = 2*k+1;
        int[][] dp = new int[prices.length][len];
        for (int i = 1; i < len; i = i + 2){
            dp[0][i] = - prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+(int)Math.pow(-1, j) * prices[i]);
            }
        }
        return dp[prices.length-1][len-1];
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2);
        List<Integer> collect = list.stream().mapToInt(Integer::intValue).boxed().collect(Collectors.toList());
        collect.add(3);

    }
}
