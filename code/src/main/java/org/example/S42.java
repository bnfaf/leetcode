package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class S42 {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }
            stack.push(current);
            current ++;
        }
        return sum;
    }
}
