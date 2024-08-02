package org.example;

public class S931 {

    public int minFallingPathSum(int[][] matrix) {
        dfs(matrix, 1);
        int value = matrix[matrix.length - 1][0];
        for (int i = 1; i < matrix[0].length; i++) {
            value = Math.min(value, matrix[matrix.length-1][i]);
        }
        return value;
    }
    public void dfs(int[][] matrix, int i){
        if (i == matrix.length){
            return;
        }
        matrix[i][0] += Math.min(matrix[i-1][0], matrix[i-1][1]);
        for (int j = 1; j < matrix.length-1; j++) {
            matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));
        }
        matrix[i][matrix[0].length-1] += Math.min(matrix[i-1][matrix[0].length-2], matrix[i-1][matrix[0].length-1]);
        dfs(matrix, i+1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {82, 81}, {69, 33}
        };
        System.out.println(new S931().minFallingPathSum(matrix));
    }
}
