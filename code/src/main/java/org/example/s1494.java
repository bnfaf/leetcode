package org.example;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.util.*;

public class s1494 {
    private int[] pre1, memo;
    private int k, u;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
//        this.k = k;
//        pre1 = new int[n];
//        for (int[] r : relations)
//            pre1[r[1] - 1] |= 1 << (r[0] - 1); // r[1] 的先修课程集合，下标改从 0 开始
//
//        u = (1 << n) - 1; // 全集
//        memo = new int[1 << n];
//        Arrays.fill(memo, -1); // -1 表示没有计算过
//        return dfs(u);
        int[] count = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        for(int[] relation : relations){
            count[relation[1]-1]++;
            ans.get(relation[1]-1).add(relation[0]-1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 0){
                queue.add(i);
            }
        }
        int sum = 0;
        while (!queue.isEmpty()){
            sum++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();
                List<Integer> list = ans.get(num);
                for(int num1 : list){
                    count[num1]--;
                    if (count[num1] == 0){
                        queue.add(num1);
                    }
                }
            }
        }
        return sum;
    }

    private int dfs(int i) {
        if (i == 0) return 0; // 空集
        if (memo[i] != -1) return memo[i]; // 之前算过了
        int i1 = 0, ci = u ^ i; // i 的补集
        for (int j = 0; j < pre1.length; j++)
            if ((i >> j & 1) > 0 && (pre1[j] | ci) == ci) // pre1[j] 在 i 的补集中
                i1 |= 1 << j;
        if (Integer.bitCount(i1) <= k)  // 如果个数小于 k，则可以全部学习，不再枚举子集
            return memo[i] = dfs(i ^ i1) + 1;
        int res = Integer.MAX_VALUE;
        for (int j = i1; j > 0; j = (j - 1) & i1) // 枚举 i1 的子集 j
            if (Integer.bitCount(j) <= k)
                res = Math.min(res, dfs(i ^ j) + 1);
        return memo[i] = res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] relations = {
                {2, 1}, {3, 1}, {1, 4}
        };
        int k = 2;
    }
}
