package org.example;

public class s74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1, n = matrix[0].length-1;
        int i = m, j = 0;
        while (i>=0 && j <= n){
            if (target < matrix[i][j]){
                i -= 1;
            }else if (target > matrix[i][j]){
                j += 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
