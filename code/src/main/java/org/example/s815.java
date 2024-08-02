package org.example;

import java.util.*;

public class s815 {


    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target){
            return 0;
        }
        return bfs(routes, source, target);

    }
    public int bfs(int[][] routes, int source, int target){
        // 某个车站可以进入的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //经过的路线
        Deque<Integer> deque = new ArrayDeque<>();
        // 进入该路线所需要的距离
        Map<Integer, Integer> dis = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int station:routes[i]){
                if (station == source){
                    deque.addLast(i);
                    dis.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!deque.isEmpty()){
            int poll = deque.pollFirst();
            int step = dis.get(poll);
            for (int station: routes[poll]){
                if (station == target){
                    return step;
                }
                Set<Integer> lines = map.get(station);
                if (lines == null){
                    continue;
                }
                for (int line: lines){
                    if (!dis.containsKey(line)){
                        dis.put(line, step+1);
                        deque.add(line);
                    }
                }
            }
        }
        return -1;

    }
}
