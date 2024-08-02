package org.example;

import java.util.*;

public class s20 {
    public boolean isValid(String s) {
        Deque<Character> queue = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Collection<Character> values = map.values();
        for(char c : s.toCharArray()){
            if (queue.isEmpty() || values.contains(c)){
                queue.add(c);
            } else if (queue.peekLast() == map.get(c)) {
                queue.pollLast();
            }else{
                return false;
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new s20().isValid("([)]"));
    }
}
