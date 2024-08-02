package org.example;

import java.util.Stack;

public class offer09 {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> temp = new Stack<Integer>();
    private int size;
    public offer09() {
        size = 0;
    }

    public void appendTail(int value) {
        stack.push(value);
        size++;
    }

    public int deleteHead() {
        if (temp.isEmpty()){
            while (!stack.isEmpty()){
                temp.push(stack.pop());
            }
        }
        if (size > 0){
            int value = temp.pop();
            size--;
            return value;
        }
        return -1;
    }
}
