package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class s131 {
    List<List<String>> res = new ArrayList<>();
    Deque<String> deque = new ArrayDeque<>();
    public List<List<String>> partition(String s) {
        backend(s, 0);
        return res;
    }
    public void backend(String s, int start){
        if (start >= s.length()){
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)){
                String str = s.substring(start, i+1);
                deque.add(str);
            }else{
                continue;
            }
            backend(s, i+1);
            deque.removeLast();
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
