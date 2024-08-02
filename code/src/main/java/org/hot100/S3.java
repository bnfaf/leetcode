package org.hot100;

import java.util.HashSet;
import java.util.Set;

public class S3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < n; i++){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                ans = Math.max(ans, right - left );
                while (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                right++;
            }
        }
        ans = Math.max(ans, right - left);
        return ans;
    }


    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j<= 9; j++){
                int a = i * 1000 + i * 100 + j * 10 + j;
                int sqrt = (int) Math.sqrt(a);
                if(sqrt * sqrt == a){
                    System.out.println(a);
                    System.out.println(sqrt);
                }
            }
        }
    }
}
