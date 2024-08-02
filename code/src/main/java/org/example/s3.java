package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class s3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        if (s.length() == 0){
            return 0;
        }
        int left = 0, maxLen = 1;
        for (int right = 0; right<s.length();right++){
            if (set.contains(s.charAt(right))){
                while (s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        s3 solution = new s3();
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}
