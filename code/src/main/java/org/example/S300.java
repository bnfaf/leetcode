package org.example;

import java.util.LinkedList;

public class S300 {
    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n+1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }else {
                        r = mid - 1;
                    }
                }
                d[pos+1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        S300 solution = new S300();
        int[] nums = {10,9,2,5,3, 1,7,101,18};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
