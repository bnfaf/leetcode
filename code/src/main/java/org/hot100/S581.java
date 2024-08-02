package org.hot100;

public class S581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = nums[0];
        rightMin[n-1] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);
            rightMin[n-1-i] = Math.min(rightMin[n-i], nums[n-i]);
        }
        int left = -1, right = n;
        while (left+1 < n && leftMax[left+1] <= rightMin[left+1]){
            left++;
        }
        left++;
        while (right-1>=0 && rightMin[right-1] >= leftMax[right-1]){
            right--;
        }
        return left < right ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        System.out.println(new S581().findUnsortedSubarray(nums));
    }
}
