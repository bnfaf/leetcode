package org.example;

import java.util.Arrays;

public class s2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[][] reward = new int[reward1.length][2];
        for (int i = 0; i < reward1.length; i++) {
            reward[i][0] = reward1[i];
            reward[i][1] = reward2[i];
        }
        Arrays.sort(reward, (a, b)->{
            return b[0] - b[1] - (a[0] - a[1]);
        });
        int sum = 0;
        for (int i = 0; i < reward.length; i++) {
            if (i < k){
                sum += reward[i][0];
            }else{
                sum += reward[i][1];
            }
        }
        return sum;
    }
    public static int bitCount(int n){
        int res = 0;
        while ( n > 0){
            res ++;
            n &= n-1;
        }
        return res;
    }

    public static void main(String[] args) {
       int[] nums = {3, 4, -1};
       int[][] p = new int[nums.length][2];
       for (int i = 0; i < nums.length; i++){
           p[i][0] =nums[i];
           p[i][1] = i;
       }
       Arrays.sort(p, (a, b) -> {
           return a[0] - b[0];
       });
       int ans = nums.length, n = ans;
       for(int k = 1; k < nums.length; k++){
           if (p[k][1] < p[k-1][1]){
               ans += n - k;
           }
       }
        System.out.println(ans);
    }
}
