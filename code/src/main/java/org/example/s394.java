package org.example;

import java.util.Stack;

public class s394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ']'){
                while (stack.peek() != '['){
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty()&&Character.isDigit(stack.peek())){
                    num.insert(0, stack.pop());
                }
                String ss = sb.toString();
                int nums = Integer.parseInt(num.toString());
                while (nums-->1){
                    sb.append(ss);
                }
                for (char c : sb.toString().toCharArray()){
                    stack.push(c);
                }
                sb.setLength(0);
            }else{
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        s394 solution = new s394();
        String s = "100[leetcode]";
        System.out.println(solution.decodeString(s));
    }
}
