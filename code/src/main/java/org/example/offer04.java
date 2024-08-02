package org.example;

public class offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        int n = matrix[0].length;
        int row = m -1, col = 0;
        while (row>=0 && col <n){
            if (matrix[row][col] > target) {
                row -= 1;
            } else if (matrix[row][col] < target) {
                col += 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
