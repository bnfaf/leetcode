package org.hot100;

import java.util.HashMap;
import java.util.Map;

public class s76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int left = 0, right = 0, len = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    count++;
                }
                while (count == need.size()){
                    if (right - left+1 < len){
                        len = right - left+1;
                        start = left;
                    }
                    char p = s.charAt(left);
                    if (need.containsKey(p)){
                        if ( window.get(p).equals(need.get(p))){
                            count--;
                        }
                        window.put(p, window.get(p)-1);
                    }
                    left++;
                }
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" :s.substring(start, start+len);
    }
}
