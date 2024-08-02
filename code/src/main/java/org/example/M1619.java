package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M1619 {
    public int[] pondSizes(int[][] land) {
        boolean[][] visit = new boolean[land.length][land[0].length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++){
                if (land[i][j] == 0 && !visit[i][j]){
                    int res = travel(i, j, visit, land);
                    list.add(res);
                }
            }
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        return array;
    }
    public int travel(int i, int j, boolean[][] visit,int[][] land){
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || visit[i][j] || land[i][j] != 0){
            return 0;
        }
        int[] direction = {-1, 0, 1, 0, -1};
        visit[i][j] = true;
        int res = 1;
        for (int k = 1; k < direction.length; k++){
            int newI = i + direction[k-1], newJ = j + direction[k];
            res += travel(newI, newJ, visit, land);
        }
        int[] directions = {-1, 1, 1, -1, -1};
        for (int k = 1; k < directions.length; k++){
            int newI = i + directions[k-1], newJ = j + directions[k];
            res += travel(newI, newJ, visit, land);
        }
        return res;
    }

    public static void main(String[] args) {
        M1619 m1619 = new M1619();
        int[][] land = {
                {0, 2, 1, 0}, {0, 1, 0, 1},
                {1, 1, 0, 1}, {0, 1, 0, 1}
        };
        System.out.println(Arrays.toString(m1619.pondSizes(land)));
    }
}
