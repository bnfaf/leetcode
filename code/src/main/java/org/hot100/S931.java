package org.hot100;

public class S931 {
    public int minFallingPathSum(int[][] matrix) {
        dfs(matrix, 1);
        int value = Integer.MAX_VALUE;
        int m = matrix.length-1;
        for (int i = 0; i < matrix[0].length; i++){
            value = Math.min(value, matrix[m][i]);
        }
        return value;
    }
    public void dfs(int[][] matrix, int index){
        if (index == matrix.length){
            return;
        }
        matrix[index][0] += Math.min(matrix[index-1][0], matrix[index-1][1]);
        for (int i = 1; i < matrix[0].length-1; i++){
            matrix[index][i] += Math.min(matrix[index-1][i], Math.min(matrix[index-1][i-1], matrix[index-1][i+1]));
        }
        matrix[index][matrix.length-1] += Math.min(matrix[index-1][matrix.length-1], matrix[index-1][matrix.length-2]);
        dfs(matrix, index+1);
    }
}
