package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class s2172 {
    public int maximumANDSum(int[] nums, int numSlots) {
        int ans = 0;
        int[] f = new int[1 << (numSlots * 2)];
        for (int i = 0; i < f.length; i++){
            int c = Integer.bitCount(i);
            if (c >= nums.length){
                continue;
            }
            for (int j = 0; j < numSlots * 2; j++){
                if ((i & (1 << j))== 0){
                    int s = i | (1 << j);
                    f[s] = Math.max(f[s], f[i] + ((j / 2 + 1) & nums[c]));
                    ans = Math.max(ans, f[s]);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        s2172 s2172 = new s2172();
        System.out.println(s2172.maximumANDSum(nums, 3));
    }
}
