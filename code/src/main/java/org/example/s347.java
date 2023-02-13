package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class s347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        int[] res = new int[k];
        for(int num : nums){
            temp.put(num, temp.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->pair2[1] - pair1[1]);
        for (Map.Entry< Integer, Integer> entry: temp.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for(int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }
        return res;

    }
}
