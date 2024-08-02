package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

public class s718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        s718 solution = new s718();
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[] {3, 2, 1, 4, 7};

    }
}
