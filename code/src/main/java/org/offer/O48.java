package org.offer;

import java.util.HashSet;
import java.util.Set;

public class O48 {
    public int lengthOfLongestSubstring(String s) {

        int length = 1;
        if (s.length() == 0){
            return 0;
        }
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()){
            char c = s.charAt(right);
            if (set.contains(c)){
                length = Math.max(length, right - left);
                while (s.charAt(left) != c && left <= right){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }else{
               set.add(c);
            }
            right++;
        }
        length = Math.max(length, right - left);
        return length;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new O48().lengthOfLongestSubstring(s));
    }
}
