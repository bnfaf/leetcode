package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class s20 {
    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{'){
                stack.push(map.get(c));
            }else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
