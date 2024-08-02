package org.hot100;

import java.util.Stack;

public class S32 {
    public int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<>();
       int res = 0;
       for (int i = 0; i<s.length(); i++){
           if (s.charAt(i) == '('){
               stack.push(i);
           }else{
               if (!stack.isEmpty()&& s.charAt(stack.peek()) == '('){
                   stack.pop();
                   if (stack.isEmpty()){
                       res = Math.max(res, i+1);
                   }else{
                       res = Math.max(res, i-stack.peek());
                   }
               }else {
                   stack.push(i);
               }
           }
       }
       return res;
    }


}
