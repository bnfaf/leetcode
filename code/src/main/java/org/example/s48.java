package org.example;

public class s48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m/2;i++){
            for (int j = 0; j < n; j++){
                swap(matrix, i, j, n-i-1, j);
            }
        }
        for(int i = 0; i < m;i++){
            for (int j = 0; j < i; j++){
                swap(matrix, i, j, j, i);
            }
        }

    }
    public void swap(int[][] matrix, int i, int j, int newX, int newY){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[newX][newY];
        matrix[newX][newY] = temp;
    }
}
