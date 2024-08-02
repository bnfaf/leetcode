package org.example;

import java.net.PasswordAuthentication;

public class s547 {

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i]= i;
        }
        for (int i = 0; i<cities; i++){
            for (int j = i+1; j < cities; j++) {
                if (isConnected[i][j] == 1){
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i){
                count++;
            }
        }
        return count;
    }
    public void union(int[] parent, int index1, int index2){
        parent[find(parent, index1)] = find(parent, index2);
    }
    public int find(int[] parent, int index){
        if (parent[index] != index){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        s547 solution = new s547();
        System.out.println(solution.findCircleNum(isConnected));
    }
}
