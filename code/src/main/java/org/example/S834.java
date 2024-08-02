package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class S834 {
    ArrayList<Integer>[] g ;
    int[] ans, size;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        ans = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for(int[] edge: edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        dfs(0, -1, 0);
        reRoot(0, -1, n);
        return ans;
    }
    public void dfs(int x, int fa, int depth){
        ans[0] += depth;
        for(int y : g[x]){
            if(y!= fa){
                dfs(y, x, depth+1);
                size[x] += size[y];
            }
        }
    }
    public void reRoot(int x, int fa, int n){
        for(int y : g[x]){
            if (y != fa){
                ans[y] = ans[x] + n-2*size[y];
                reRoot(y, x, n);
            }
        }
    }
}
