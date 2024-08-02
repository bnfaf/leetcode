package org.example;

import java.awt.image.ImagingOpException;
import java.util.HashMap;
import java.util.Map;

public class s765 {
    int[] p = new int[70];
    public void union(int a, int b){
        p[find(a)] =p[find(b)];
    }
    public int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public int minSwapsCouples(int[] row) {
        /**
         * 若有k对成环做错位置，则需要k-1步，所以需要计算有多少个环
         * 将row/2作为组号进行，对row[i],row[i+1]进行建环
         * 这里使用并查集进行
         */
        int n = row.length, m = n/ 2;
        for (int i = 0; i < m ; i++){
            p[i] = i;
        }
        for (int i = 0; i < n; i+= 2){
            union(row[i]/2, row[i+1]/2);
        }
        int cnt = 0;
        for (int i = 0; i < m; i++){
            if (i == find(i)){
                cnt++;
            }
        }
        return m - cnt;
    }

    public static void main(String[] args) {
        int[] row = {0, 1, 2, 3, 4, 6, 7, 5};
        s765 solution = new s765();
        System.out.println(solution.minSwapsCouples(row));
    }

}
