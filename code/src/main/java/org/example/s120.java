package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s120 {
    /**
     *还可以考虑自底向上
     * 这边优化的话可以考虑倒序
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        int min = 0;
        for (int i = 0; i < triangle.get(0).size(); i++) {
            dp[0][i] = triangle.get(0).get(i);
            min = Math.min(min, dp[0][i]);
        }

        for(int i = 1; i < m;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            min = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++){
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        s120 solution = new s120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(triangle));
    }
}
