package org.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class S1130 {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int x : arr){
            while (!deque.isEmpty() && deque.peekLast() <= x){
                int y = deque.pollLast();
                if (deque.isEmpty() || deque.peekLast() > x){
                    res += y * x;
                }else{
                    res += deque.peekLast() * y;
                }
            }
            deque.addLast(x);
        }
        while (deque.size() >= 2){
            int x = deque.pollLast();
            res += deque.peekLast() * x;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 4};
        System.out.println(new S1130().mctFromLeafValues(arr));
    }
}
