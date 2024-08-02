package org.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]){
                int day = deque.pollLast();
                ans[day] = i - day;
            }
            deque.addLast(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] tem = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new S739().dailyTemperatures(tem)));
    }
}
