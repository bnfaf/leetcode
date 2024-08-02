package org.hot100;

import java.util.Stack;

public class S394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i) == ']'){
                StringBuilder sb1 = new StringBuilder();
                while (stack.peek() != '['){
                    sb1.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty()&& Character.isDigit(stack.peek())){
                    num.insert(0, stack.pop());
                }
                int n = Integer.parseInt(num.toString());
                while (n-->0){
                    for (char c : sb1.toString().toCharArray()){
                        stack.add(c);
                    }
                }
            }else{
                stack.add(s.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(new S394().decodeString(s));
    }
}
