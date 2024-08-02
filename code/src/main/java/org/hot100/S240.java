package org.hot100;

public class S240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = m-1, col = 0;
        while (row>=0 && col < n){
            if (matrix[row][col] > target){
                row -= 1;
            } else if (matrix[row][col] < target) {
                col+= 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
