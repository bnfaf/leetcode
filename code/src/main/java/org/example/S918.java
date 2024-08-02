package org.example;

import java.util.Arrays;

public class S918 {
    public int maxSubarraySumCircular(int[] nums) {
        // 环形 则最大为nums[i]~nums[j] 或nums[0]~nums[i-1]+nums[j]~nums[n-1],
        //第一个使用pre记录即可  第二个需要【0，i-1]的最大和，以及后序遍历的和，前一部分可以在第一个中记录，后一部分在循环时记录
        int n = nums.length;
        int[] leftMax = new int[n];
        // leftMax[i]表示[0, i]为边界的，0为起点的最大连续子数组的和
        leftMax[0] = nums[0];
        int leftSum = nums[0];
        int pre = nums[0], res = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre+nums[i], nums[i]);
            res = Math.max(res, pre);
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i-1], leftSum);
        }

        int rightSum = 0;
        for (int i = n-1; i> 0; i--){
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,2,6};
        System.out.println(new S918().maxSubarraySumCircular(nums));
    }
}
