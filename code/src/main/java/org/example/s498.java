package org.example;

import java.util.Arrays;

public class s498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = 0, col = 0;
        int m = mat.length, n = mat[0].length;
        int[] nums = new int[m*n];
        int index = 0;
        while (row < m && col < n){
            while (row>=0 && row < m&& col < n&&col>=0){
                nums[index++] = mat[row--][col++];
            }
            if (col >= 0 && col < n){
                row++;
            } else if (col == n) {
                row+=2;
                col = n-1;
            }
            while (row>=0 && row < m&& col < n&&col>=0){
                nums[index++] = mat[row++][col--];
            }
            if (row >= 0 &&row < m){
                col = 0;
            } else if (row == m) {
                row --;
                col += 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        s498 solution = new s498();
        System.out.println(Arrays.toString(solution.findDiagonalOrder(mat)));
    }
}
