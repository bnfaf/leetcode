package org.example;

import java.util.Arrays;

public class s684 {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for (int i = 0; i <= edges.length; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges){
            int indexX = edge[0], indexY = edge[1];
            if (find(indexX) == find(indexY)){
                return edge;
            }else{
                union(indexX, indexY);
            }
        }
        return new int[0];
    }
    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y){
        parent[find(x)] = parent[find(y)];
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        };
        s684 solution = new s684();
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges)));
    }
}
