package org.example;

import java.util.Arrays;

public class s189 {
    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        s189 solution = new s189();
        int[] nums = new int[]{-1,-100,3,99};
        solution.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
