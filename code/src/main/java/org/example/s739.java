package org.example;

import java.net.PasswordAuthentication;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class s739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> ans = new Stack<Integer>();
        int[] res = new int[temperatures.length];
        ans.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] < temperatures[ans.peek()]){
                ans.push(i);
            }else{
                while (!ans.isEmpty() && temperatures[i] > temperatures[ans.peek()]){
                    res[ans.peek()] = i - ans.peek();
                    ans.pop();
                }
                ans.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        s739 solution = new s739();
        int[] tem = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(tem)));
    }
}
