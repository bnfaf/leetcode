package org.example;

import java.util.*;

public class s2711 {
    public static int[][] differenceOfDistinctValues(int[][] grid) {
        Map<Integer, Set<Integer>> pre = new HashMap<Integer, Set<Integer>>();
        int[][] preArray = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Set<Integer> set = pre.getOrDefault(i - j, new HashSet<Integer>());
                set.add(grid[i][j]);
                preArray[i][j] = set.size();
                pre.put(i-j, set);
            }
        }
        Map<Integer, Set<Integer>> post = new HashMap<Integer, Set<Integer>>();
        int[][] postArray = new int[grid.length][grid[0].length];
        for (int i= grid.length-1; i>=0; i--){
            for (int j = grid[i].length-1; j>=0; j--){
                Set<Integer> set = post.getOrDefault(i - j, new HashSet<Integer>());
                set.add(grid[i][j]);
                postArray[i][j] = set.size();
                post.put(i-j, set);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int left = i>0 && j>0 ? preArray[i-1][j-1] : 0;
                int right = i+1<grid.length && j+1 < grid[0].length ? postArray[i+1][j+1] : 0;
                grid[i][j] = Math.abs(left - right);

            }
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grides = {
                {1, 2, 3},
                {3, 1, 5},
                {3, 2, 1}
        };
        System.out.println(Arrays.deepToString(differenceOfDistinctValues(grides)));
    }
}
