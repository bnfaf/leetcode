package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

import java.util.*;
import java.util.jar.Pack200;

public class s85 {

    public int maximalRectangle(char[][] matrix) {
       int m = matrix.length, n = matrix[0].length, ans = 0;
       int[][] sum = new int[m+1][n+1];
       for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= n; j++) {
               sum[i][j] = matrix[i-1][j-1] == '1' ? sum[i-1][j]+1:0;
           }
       }
       int[] l = new int[n+1], r = new int[n+1];


       for (int i = 1; i <= m; i++){
           Deque<Integer> deque = new ArrayDeque<>();
           int[] cur = sum[i];
           Arrays.fill(l, 0);
           Arrays.fill(r, n+1);
           for (int j = 1; j <= n; j++) {
               while (!deque.isEmpty() && cur[deque.peekLast()] > cur[j]){
                   r[deque.pollLast()] = j;
               }
               deque.addLast(j);
           }
           deque.clear();
           for (int j = n; j>=1; j--){
               while (!deque.isEmpty() && cur[deque.peekLast()] > cur[j]){
                   l[deque.pollLast()] = j;
               }
               deque.addLast(j);
           }
           for (int j = 1; j <= n; j++) {
               // [i-1, j+1], 正确应为[i,j]
               ans = Math.max(ans, cur[j] * (r[j] - l[j]-1));
           }
       }
       return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        s85 solution = new s85();

        System.out.println(solution.maximalRectangle(matrix));
    }

}
