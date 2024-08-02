package org.example;

import java.util.*;

public class S365 {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<>();
        while (!stack.isEmpty()){
            if (seen.contains(hash(stack.peek()))){
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));
            int[] state = stack.pop();
            int remain1 = state[0], remain2 = state[1];
            if (remain1 + remain2 == targetCapacity){
                return true;
            }
            stack.push(new int[]{remain1, jug2Capacity});
            stack.push(new int[]{jug1Capacity, remain2});
            stack.push(new int[]{0, remain2});
            stack.push(new int[]{remain1, 0});
            stack.push(new int[]{remain1 - Math.min(remain1, jug2Capacity - remain2), remain2 + Math.min(remain1, jug2Capacity - remain2)});
            stack.push(new int[]{remain1 + Math.min(remain2, jug1Capacity - remain1), remain2 - Math.min(remain2, jug1Capacity - remain1)});
        }
        return false;
    }
    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }



    public static void main(String[] args) {
        S365 s365 = new S365();
        System.out.println(s365.canMeasureWater(3, 5, 4));
    }
}
