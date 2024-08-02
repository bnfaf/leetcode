package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class s134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, totalSum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0){
                start = i+1;
                curSum = 0;
            }
        }

        return totalSum < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        s134 solution = new s134();
        int circuit = solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(circuit);
    }
}
