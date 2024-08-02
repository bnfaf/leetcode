package org.example;

public class S1631 {
    int res = Integer.MAX_VALUE;
    public int minimumEffortPath(int[][] heights) {
        travel(heights, 0, 0, -1, -1, 0);
        return res;
    }
    public void travel(int[][] heights, int i, int j, int originI, int originJ, int value){
        if (i == heights.length-1 && j == heights[0].length-1){
            res = Math.min(res, value);
            return;
        }
        int[] directions = {-1, 0, 1, 0, -1};
        for (int k = 1; k < directions.length; k++){
            int newI = i + directions[k-1], newJ = j + directions[k];
            if (i == originI && j == originJ){
                continue;
            }
            if (newI < 0 || newI >= heights.length  || newJ < 0 || newJ >= heights[0].length){
                continue;
            }
            travel(heights, newI, newJ, i, j,  Math.max(value, Math.abs(heights[newI][newJ] - heights[i][j])));
        }
    }

    public static void main(String[] args) {
        S1631 s1631 = new S1631();
        int[][] heights = {
                {1,2,1,1,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,1,1,2,1}
        };
        System.out.println(s1631.minimumEffortPath(heights));
    }
}
