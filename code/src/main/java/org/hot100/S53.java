package org.hot100;

public class S53 {
    public int maxSubArray(int[] nums) {
        int pre = nums[0], ans = pre;
        for (int i = 1; i < nums.length; i++){
            pre = Math.max(pre+nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;

    }
}
