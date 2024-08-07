package org.example;

import java.awt.image.ImagingOpException;
import java.util.HashMap;
import java.util.Map;

public class s1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] f = new int[n][1001];
        for (int i = 1; i < n;i++){
            for (int k = 0; k < i; k++){
                int j = nums[i] - nums[k] + 500;
                f[i][j] = Math.max(f[i][j], f[k][j] + 1);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4,  7, 2, 10};
        s1027 solution = new s1027();
        System.out.println(solution.longestArithSeqLength(nums));
    }
}
