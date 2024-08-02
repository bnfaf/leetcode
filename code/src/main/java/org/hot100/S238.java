package org.hot100;

import java.util.Arrays;

public class S238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n-1] =1;
        int pre = 1;
        for (int i = n-2; i>=0; i--){
            right[i] = pre * nums[i+1];
            pre = right[i];
        }
        int[] ans = new int[n];
        ans[0] = pre;
        pre = nums[0];
        for (int i = 1; i< n-1;i++){
            ans[i] = pre * right[i];
            pre *= nums[i];
        }
        ans[n-1] = pre;
        return  ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2, 3, 4};
        System.out.println(Arrays.toString(new S238().productExceptSelf(nums)));
    }
}
