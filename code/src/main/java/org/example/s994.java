package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class s994 {
    Deque<int[]> queue = new ArrayDeque<>();
    int sum = 0;
    int m , n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2){
                    queue.addLast(new int[]{i, j});
                }
                if (grid[i][j] == 1){
                    sum += 1;
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        int min = 0;
        while (!queue.isEmpty() && sum > 0){
            int size = queue.size();
            while (size-- > 0){
                int[] temp = queue.pollFirst();
                for (int k = 0; k < 4; k++){
                    if (isValid(temp[0]+dirs[k], temp[1]+dirs[k+1]) && grid[temp[0]+dirs[k]][temp[1]+dirs[k+1]] == 1){
                        sum--;
                        grid[temp[0]+dirs[k]][temp[1]+dirs[k+1]] = 2;
                        queue.addLast(new int[]{temp[0]+dirs[k], temp[1]+dirs[k+1]});
                    }
                }
            }
            min += 1;
        }
        return sum == 0 ? min:-1;
    }

    public boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
