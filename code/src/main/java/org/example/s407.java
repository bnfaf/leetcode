package org.example;

import java.util.PriorityQueue;

public class s407 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2)->o1[1] - o2[1]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i * n + j, heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] direction = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            for(int k = 0; k<4;k++){
                int nx = curr[0]/n+direction[k];
                int ny = curr[0]%n+direction[k+1];
                if (nx>=0 && nx < m && ny >=0 && ny < n && !visit[nx][ny]){
                    if (curr[1] > heightMap[nx][ny]){
                        res +=(curr[1] - heightMap[nx][ny]);
                    }
                    pq.offer(new int[]{nx*n+ny, Math.max(heightMap[nx][ny], curr[1])});
                    visit[nx][ny] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] map = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        s407 solution = new s407();
        System.out.println(solution.trapRainWater(map));
    }
}
