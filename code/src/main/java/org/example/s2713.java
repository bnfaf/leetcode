package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class s2713 {
    static int res = 0;
    public static int maxIncreasingCells(int[][] mat) {
        TreeMap<Integer, List<int[]>> g = new TreeMap<Integer, List<int[]>>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                // 相同元素放在同一组，统计位置
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});

        int ans = 0;
        int[] rowMax = new int[m], colMax = new int[n];
        for (List<int[]> pos : g.values()) {
            int[] mx = new int[pos.size()];  // 先把最大值算出来，再更新 rowMax 和 colMax
            for (int i = 0; i < pos.size(); i++) {
                mx[i] = Math.max(rowMax[pos.get(i)[0]], colMax[pos.get(i)[1]]) + 1;
                ans = Math.max(ans, mx[i]);
            }
            for (int k = 0; k < pos.size(); k++) {
                int i = pos.get(k)[0], j = pos.get(k)[1];
                rowMax[i] = Math.max(rowMax[i], mx[k]); // 更新第 i 行的最大 f 值
                colMax[j] = Math.max(colMax[j], mx[k]); // 更新第 j 列的最大 f 值
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {3, 1, 6},
                {-9, 5, 7}
        };
        int cells = maxIncreasingCells(mat);
        System.out.println(cells);
    }

}
