package org.example;

public class offer9 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, n = nums.length;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++){
            prod *= nums[j];
            // 本质上是锚定j之后，寻找满足左端点的最小值
            while (i<= j&&prod>=k){
                prod /= nums[i];
                i++;
            }
            res += j-i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        offer9 solution = new offer9();
        int[] nums = {10,5,2,6};
        System.out.println(solution.numSubarrayProductLessThanK(nums, 100));
    }
}
