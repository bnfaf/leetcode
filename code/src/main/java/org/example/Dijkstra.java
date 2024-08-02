package org.example;

import java.util.Arrays;

public class Dijkstra {
    public int[] getDis(int[][] graph, int source){
        int n = graph.length;
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean[] visit = new boolean[n];
        Arrays.fill(visit, false);
        dis[source] = 0;
        for (int i = 0; i < n; i++) {
            int node = -1;
            for (int j = 0; j < n; j++) {
                if (!visit[j] && (node == -1 || dis[j] < dis[node])){
                    node = j;
                }
            }
            for (int j = 0; j < n; j++) {
                dis[j] = Math.min(dis[j], dis[node] + graph[node][j]);
            }
            visit[node] = true;
        }
        return dis;
    }
}
