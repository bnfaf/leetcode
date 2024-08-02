package org.example;

import java.util.*;

public class s207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] nums = new int[numCourses];
        // 前置 学会内容
        Map<Integer, Set<Integer>> need  = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            nums[pre[0]] += 1;
            Set<Integer> set = need.getOrDefault(pre[1], new HashSet<>());
            set.add(pre[0]);
            need.put(pre[1], set);
        }
        for (int i = 0; i < numCourses; i++) {
            if(nums[i] == 0){
                deque.addLast(i);

            }
        }
        while (!deque.isEmpty()){

            int p = deque.pollFirst();
            // 可以考虑去尝试加入
            Set<Integer> set =  need.getOrDefault(p, null);
            if (set != null){
                for (Integer value : set){
                    nums[value] -= 1;
                    if (nums[value] == 0){
                        deque.addLast(value);
                    }

                }
            }
        }
        return Arrays.stream(nums).sum() == 0;
    }

    public static void main(String[] args) {
        int num = 2;
        int[][] pre = {{1, 0}};
        s207 solution = new s207();
        System.out.println(solution.canFinish(num, pre));

    }
}
