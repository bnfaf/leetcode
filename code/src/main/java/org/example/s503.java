package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class s503 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        int[] result = new int[size];
        Arrays.fill(result,-1);
        Stack<Integer> st= new Stack<>();
        for(int i = 0; i < 2*size; i++) {
            while(!st.empty() && nums[i % size] > nums[st.peek()]) {
                result[st.peek()] = nums[i % size];
                st.pop();//弹出栈顶
            }
            st.push(i % size);
        }
        return result;
    }

    public static void main(String[] args) {
        s503 solution = new s503();
        int[] nums = new int[]{1,2,3,4,3};
        System.out.println(Arrays.toString(solution.nextGreaterElements(nums)));
    }
}
