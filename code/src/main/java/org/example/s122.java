package org.example;

public class s122 {
    public int maxProfit(int[] prices) {
        int a = 0, b = -prices[0]; // 未持有当前股票的最大收益，持有当前股票的最大收益
        int tempA, tempB;
        for (int i = 1; i < prices.length; i++) {
            tempA = a;
            tempB = b;
            a = Math.max(tempA, tempB+prices[i]);
            b = Math.max(tempB, tempA - prices[i]);
        }
        return a;
    }

    public static void main(String[] args) {
        s122 solution = new s122();
        int[] nums = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(nums));
    }
}
