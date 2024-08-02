package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class s6447 {
    int n;
    int[][] memo;
    int[] cost, time;
    public int paintWalls(int[] cost, int[] time) {
//        this.n = cost.length;
//        this.cost = cost;
//        this.time = time;
//        this.memo = new int[n][2 * n + 1];// 免费时长可以为负数，因此需要加偏移量
//        for (int i = 0; i < n; i++){
//            Arrays.fill(memo[i], -1);
//        }
//        return dfs(n - 1, n);// 偏移量防止负数
        int n = cost.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2); // 防止加法溢出
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i], t = time[i] + 1;  // 注意这里加一了
            for (int j = n; j > 0; j--)
                f[j] = Math.min(f[j], f[Math.max(j - t, 0)] + c);
        }
        return f[n];

    }
    // 免费时长为j，刷前i片墙需要的最小花费
    public int dfs(int i, int j){
        if (i < j - n) return 0;// 剩余所有墙都可以由免费油漆工刷
        if (i < 0) return 0x3f3f3f3f;
        if (memo[i][j] != -1) return memo[i][j];
        // 免费油漆工刷
        int res = dfs(i - 1, j - 1);
        // 付费油漆工刷
        res = Math.min(res, dfs(i - 1, j + time[i]) + cost[i]);
        return memo[i][j] = res;
    }

    public static void main(String[] args) {
        int[] cost = {2,3,4,2};
        int[] time = {1,1,1,1};
        System.out.println(new s6447().paintWalls(cost, time));
    }
}
