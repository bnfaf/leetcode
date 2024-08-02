package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class S1466 {
    public static int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        int count = 0;
        visited[0] = true;
        List<Integer> queue = new LinkedList<>();
        for(int i = 0; i < connections.length; i++){
            int[] connection = connections[i];
            if(connection[1] == 0){
                visited[connection[0]] = true;
            }else{
                queue.add(i);
            }
        }
        int res = 0;
        while (queue.size() > 0){
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()){
                Integer index = iterator.next();
                int[] connection = connections[index];
                if(visited[connection[0]] && !visited[connection[1]]){
                    visited[connection[1]] = true;
                    iterator.remove();
                    res++;
                }
                if(visited[connection[1]] && !visited[connection[0]]) {
                    visited[connection[0]] = true;
                    iterator.remove();
                }
            }
        }
        return res;
    }
    public static int dfs(int x, int parent, List<int[]>[] e){
        int res = 0;
        for (int[] edge : e[x]){
            if (edge[0] == parent){
                continue;
            }
            res += edge[1] + dfs(edge[0], x, e);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(n, connections));
    }
}
