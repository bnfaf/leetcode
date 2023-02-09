package org.example;

public class s59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startx = 0, starty = 0;
        int loop = n / 2;
        int offset = 1;
        int count = 1;
        while (loop-- > 0){
            int i = startx, j = starty;
            for (;j < n - offset; j++){
                res[startx][j] = count++;
            }
            for (;i < n - offset; i++){
                res[i][j] = count++;
            }
            for (;j > starty;j--){
                res[i][j] = count++;
            }
            for (;i > startx; i--){
                res[i][j] = count++;
            }
            startx += 1;
            starty += 1;
            offset += 1;
        }
        if (n % 2 == 1){
            res[startx][starty] = count;
        }
        return res;
    }
}
