package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class s84 {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length+2];
        newHeights[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i+1] = heights[i];
        }
        newHeights[newHeights.length - 1] = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int res = 0;
        for (int i = 0; i < newHeights.length; i++) {
            if (newHeights[i] > newHeights[stack.peek()]){
                stack.push(i);
            } else if (newHeights[i] == newHeights[stack.peek()]) {
                continue;
            }else{
                while (heights[i] < heights[stack.peek()]){
                    int mid = newHeights[stack.pop()];
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1;
                    res = Math.max(res, w * mid);
                }
                stack.push(i);
            }
        }
        return res;


    }

    public static void main(String[] args) {
        s84 solution = new s84();
        int[] nums = new int[]{2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(nums));
    }
}
