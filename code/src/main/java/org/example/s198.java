package org.example;

import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class s198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] path = new int[nums.length];
        path[0] = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        path[1] = dp[0] > nums[1] ? 0 : 1;
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
            path[i] = dp[i-1] > dp[i-2]+nums[i] ? i-1 : i-2;
        }
        // 获取路径
        List<Integer> paths = new ArrayList<>();
        int l = path[path.length - 1];
        if (l == path.length - 3){
            paths.add(path.length-1);
        }
        if (l > 0){
            paths.add(l);
            l = path[l];
        }
        if (l == 0){
            paths.add(l);
        }
        Collections.reverse(paths);
        System.out.println(paths);
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        s198 solution = new s198();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(solution.rob(nums));
    }
}
