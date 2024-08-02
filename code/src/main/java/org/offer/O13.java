package org.offer;

public class O13 {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (get(i) + get(j) <= k & ((i>=1&&vis[i-1][j]) | (j>=1&&vis[i][j-1]) | (i == 0 && j == 0))){
                    res++;
                    vis[i][j] = true;
                }
            }
        }
        return res;
    }
    public int get(int x){
        int res = 0;
        while (x>0){
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O13().movingCount(16, 8, 4));;
    }
}
