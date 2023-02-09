package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class S232 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public S232() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        System.out.println(inStack);
        System.out.println(outStack);
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out(){
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
