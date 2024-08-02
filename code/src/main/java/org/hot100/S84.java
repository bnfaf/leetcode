package org.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left =new int[n], right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            while (!deque.isEmpty() && heights[deque.peekLast()] > heights[i]){
                right[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }
        deque.clear();
        for (int i = n-1; i>=0; i--){
            while (!deque.isEmpty() && heights[deque.peekLast()] > heights[i]){
                left[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i<n; i++){
            int t = heights[i], a = left[i], b = right[i];
            ans = Math.max(ans, (b-a-1) * t);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
