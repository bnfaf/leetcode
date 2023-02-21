package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class s1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {

        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (k% 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        s1005 solution = new s1005();
        int[] nums = new int[]{3, -1, 0, 2};
        System.out.println(solution.largestSumAfterKNegations(nums, 3));
    }
}
