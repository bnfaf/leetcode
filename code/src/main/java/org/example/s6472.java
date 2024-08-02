package org.example;

import java.util.*;

public class s6472 {
    public static long matrixSumQueries(int n, int[][] queries) {
        long res = 0;
        int num = 0;
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        for (int i = queries.length-1; i >= 0; i--) {
            if (num == n * n){
                break;
            }
            int index = queries[i][1];
            int val = queries[i][2];
            if (queries[i][0] == 0){
                if (!row.contains(index)){
                    res += (long) val * (n - col.size());
                    num += (n - col.size());
                    row.add(index);
                }

            }else{
                if (!col.contains(index)){
                    res += (long) val * (n-row.size());
                    num += (n-row.size());
                    col.add(index);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] queries = {
                {0, 0, 1}, {1, 2, 2},
                {0, 2, 3}, {1, 0, 4}
        };
        System.out.println(matrixSumQueries(3, queries));
    }
}
