package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class S2208 {
    public int halveArray(int[] nums) {
        double sum = 0;
        double target = 0.0;
        int count = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });
        for(int num : nums){
            sum += num;
            queue.add((double) num);
        }
        while (target < sum / 2){
            double poll = queue.poll();
            target += poll / 2;
            queue.add(poll/2);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,8,20};
        System.out.println(new S2208().halveArray(nums));
    }

}
