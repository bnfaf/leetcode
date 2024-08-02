package org.example;

import java.util.Stack;

public class s32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        if (s.length() == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    if (!stack.isEmpty()){
                        res = Math.max(res, i - stack.peek());
                    }else {
                        res = Math.max(res, i+1);
                    }
                }else{
                    stack.push(i);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = ")()())";
        s32 solution = new s32();
        System.out.println(solution.longestValidParentheses(s));
    }
}
