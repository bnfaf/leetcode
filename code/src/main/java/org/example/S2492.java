package org.example;

import java.util.*;

public class S2492 {

    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE, min = ans;
        List<int[]>[] adjs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int[] road : roads) {
            adjs[road[0]].add(new int[]{road[1], road[2]});
            adjs[road[1]].add(new int[]{road[0], road[2]});
            min = Math.min(min, road[2]);
        }
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] next : adjs[cur]) {
                ans = Math.min(ans, next[1]); // 先判断当前边的距离（确保每一条边都能遍历到）
                if (ans == min) return ans;
                if (vis[next[0]]) continue; // 再判断是否已经添加到队列
                queue.offer(next[0]);
                vis[next[0]] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
