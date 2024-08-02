package org.example;

import java.util.HashMap;
import java.util.Map;

public class s6893 {
    private static final int MOD = (int) 1e9 + 7;
    private int[][] f = new int[1 << 14][14];
    private int n;
    public int specialPerm(int[] nums) {
//        1.。 全排列搜索
        // 2. 记忆化搜索
        // 3. 集合翻译成二进制位运算
        n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            ans = (ans + dfs(((1 << n) - 1) ^ (1 << i), i, nums)) % MOD;
        }
        return ans;
    }
    public  int dfs(int i, int j, int[] nums){
        if (i == 0){
            return 1;
        }
        if (f[i][j] > 0){
            return f[i][j];
        }
        int res = 0;
        for (int k = 0; k < n; k++){
            if (((i >> k ) & 1) == 1 && (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0)){
                res = (res + dfs(i ^ (1 << k), k, nums)) % MOD;

            }
        }
        f[i][j] = res % MOD;
        return f[i][j];
    }

}
