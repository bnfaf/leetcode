package org.example;

import java.util.Stack;

public class s402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (char c: num.toCharArray()){
            while (!stack.isEmpty()&& c < stack.peek()&& k>0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (!stack.isEmpty()&&k>0){
            k--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        while (sb.length()>0&&sb.charAt(sb.length() - 1) == '0'){
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.reverse();
        return sb.length()>0?sb.toString():"0";
    }

    public static void main(String[] args) {
        String num = "10200";
        s402 solution = new s402();
        System.out.println(solution.removeKdigits(num, 1));
    }
}
