package org.example;

public class S1911 {
    public long maxAlternatingSum(int[] nums) {
        // 动态规划   even表示从【0，i-]中选择元素并且最后一个元素为奇数的最优子序列 odd 则表示最后一个元素为偶数的最优子序列
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++){
            even = Math.max(even, odd+nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }
}
