package org.example;

import java.util.*;

/**
 * @author Administrator
 */
public class s10 {
    public static boolean isValid(String s) {
        final Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('{', '}');
                put('[', ']');
                put('(', ')');
                put('?', '?');

            }
        };
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (!map.get(stack.removeLast()).equals(c)) {
                return false;
            }
        }
        return stack.size() == 1;
    }


    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
