package org.hot100;

import java.util.*;

public class S207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] course = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre:prerequisites){
            course[pre[0]]+=1;
            List<Integer> integerList = map.getOrDefault(pre[1], new ArrayList<>());
            integerList.add(pre[0]);
            map.put(pre[1], integerList);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i<numCourses; i++){
            if (course[i] == 0){
                deque.addLast(i);
            }
        }
        num += deque.size();
        while (!deque.isEmpty()){
            Integer integer = deque.pollFirst();
            List<Integer> list = map.get(integer);
            if (list!=null){
                for (int nums : list){
                    course[nums] -= 1;
                    if (course[nums] == 0){
                        deque.addLast(nums);
                        num += 1;
                    }
                }
            }
        }
        return num == numCourses;
    }

    public static void main(String[] args) {
        int[][] pre = {{1, 0}};
        System.out.println(new S207().canFinish(2, pre));
    }
}
