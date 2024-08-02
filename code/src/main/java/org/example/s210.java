package org.example;

import java.util.*;

public class s210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] learn = new int[numCourses];
        int[] nums = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            Set<Integer> set = map.getOrDefault(pre[1], new HashSet<>());
            set.add(pre[0]);
            map.put(pre[1], set);
            nums[pre[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] == 0){
                learn[index++] = i;
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()){
            int p = deque.pollFirst();
            Set<Integer> set = map.getOrDefault(p, null);
            if (set != null){
                for(Integer value : set){
                    nums[value] --;
                    if (nums[value] == 0){
                        learn[index++] = value;
                        deque.addLast(value);
                    }
                }
            }
        }
        return index < numCourses?new int[0]:learn;
    }

}
