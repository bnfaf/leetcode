package org.offer;

public class o49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++){
            int nums2 = dp[p2] * 2, nums3 = dp[p3] * 3, nums5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(nums2, nums3), nums5);
            if (dp[i] == nums2){
                p2++;
            }
            if (dp[i] == nums3){
                p3++;
            }
            if (dp[i] == nums5){
                p5++;
            }
        }
        return dp[n];
    }
}
