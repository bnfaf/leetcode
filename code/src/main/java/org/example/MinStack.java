package org.example;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Long> xStack;
    long minValue = -1;

    public MinStack() {
        xStack = new LinkedList<>();
    }

    public void push(long val) {
        if (xStack.isEmpty()){
            xStack.push(0L);
            minValue = val;
        }else {
            Long diff = val - minValue;
            xStack.push(diff);
            minValue = diff > 0 ? minValue:val;
        }
    }

    public void pop() {
        if (!xStack.isEmpty()) {
            long diff = xStack.pop(), top;
            if (diff < 0){
                top = minValue;
                minValue = top - diff;
            }else {
                top = minValue + diff;
            }
        }
    }

    public long top() {
        return  (xStack.peek() < 0 ? minValue : minValue + xStack.peek());
    }

    public Long getMin() {
        return xStack.isEmpty() ? -1 :  minValue;
    }
}
