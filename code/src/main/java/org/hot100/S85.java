package org.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] sum = new int[m+1][n+1];
        for (int i = 1; i<=m; i++){
            for (int j = 1; j <= n; j++){
                if (matrix[i-1][j-1] == '1'){
                    sum[i][j] = sum[i-1][j]+1;
                }
            }
        }
        int[] l = new int[n+1], r = new int[n+1];
        for (int i = 1; i <= m; i++){
            int[] cur = sum[i];
            Arrays.fill(l, 0);
            Arrays.fill(r, n+1);
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 1; j<=n; j++){
                while (!deque.isEmpty() && cur[deque.peekLast()] > cur[j]){
                    r[deque.pollLast()] = j;
                }
                deque.addLast(j);
            }
            deque.clear();
            for (int j = n; j>= 1; j--){
                while (!deque.isEmpty() && cur[deque.peekLast()] > cur[j]){
                    l[deque.pollLast()] = j;
                }
                deque.addLast(j);
            }
            for (int j = 1; j<=n; j++){
                ans = Math.max(ans, cur[j] * (r[j] - l[j] -1));
            }
        }
        return ans;
    }
}
