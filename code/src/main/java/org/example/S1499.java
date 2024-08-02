package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class S1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // max yi+yj+|xi-xj| = yi+yj+xj-xi = (yi+yj)+(yi-xi)
        // 当j已知时，维护yi-xi的最大值
        int res = Integer.MIN_VALUE;
        Deque<int[]> deque = new ArrayDeque<>();
        for(int[] point : points){
            int x = point[0], y = point[1];
            // 维护窗口
            while (!deque.isEmpty() && deque.peekFirst()[0] < x-k){
                deque.pollFirst();
            }
            if (!deque.isEmpty()){
                res = Math.max(res, x + y + deque.peekFirst()[1]);
            }
            // 维护队列
            while (!deque.isEmpty() && deque.peekLast()[1] <= y-x){
                deque.pollLast();
            }
            deque.addLast(new int[]{x, y-x});
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {
                {-19, 1}, {-18, -13}, {-17, -12}, {-14, -14}, {-8, -9}, {-6, 16}, {-2, -4},
                {2, 15}, {4, 19}, {5, -9}, {6, 20}, {7, -17}, {16, 3}
        };
        System.out.println(new S1499().findMaxValueOfEquation(points, 1));
    }
}
