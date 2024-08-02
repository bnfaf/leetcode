package org.example;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class DijkstraAlgorithm {
    public static int[][] buildGraph(int[][] graph){
        int n = graph.length;
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (graph[i][j] != 0){
                    inDegree[j]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> topOrder = new ArrayList<>();
        while (!queue.isEmpty()){
            int u = queue.poll();
            topOrder.add(u);
            for (int v = 0; v < n; v++){
                if (graph[u][v] != 0){
                    inDegree[v]--;
                    if (inDegree[v] == 0){
                        queue.offer(v);
                    }
                }
            }
        }
        int[][] newGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(newGraph[i], 0);
        }
        for (int i = 0; i < topOrder.size(); i++){
            int u = topOrder.get(i);
            for (int v = 0; v < n; v++){
                if (graph[u][v] != 0 && (i == 0 || !topOrder.subList(0, i).contains(v))) {
                    newGraph[u][v] = graph[u][v];
                }
            }
        }
        return newGraph;
    }
    public static int[][] diskstra(int[][] graph, int source){
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for (int i = 0; i < n; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < n;v++){
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        int [][] result = new int[2][n];
        for (int i = 0; i < n; i ++){
            result[0][i] = dist[i];
            result[1][i] = i;
        }
        return result;
    }
    public static int minDistance(int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
//        int[][] graph = {{0, 10, 0, 30, 100},
//                {10, 0, 50, 0, 0},
//                {0, 50, 0, 20, 10},
//                {30, 0, 20, 0, 60},
//                {100, 0, 10, 60, 0}};
//        int source = 0;
//        int [][] result = diskstra(graph, source);
//        System.out.println(Arrays.deepToString(result));
        int[][] graph = {{0, 10, 0, 30, 100},
                {0, 0, 50, 0, 0},
                {0, 0, 0, 20, 10},
                {0, 0, 0, 0, 60},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.deepToString(buildGraph(graph)));
    }
}
