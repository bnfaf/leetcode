package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class S438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] need = new int[26];
        int[] windows = new int[26];
        int count = 0;
        for(char c : p.toCharArray()){
            need[c - 'a'] += 1;
            if (need[c - 'a'] == 1){
                count++;
            }
        }
        int Count = 0;
        for (int i = 0; i < s.length(); i++){
            int point = s.charAt(i) - 'a';
            windows[point] ++;
            if (windows[point] == need[point]){
                Count++;
            }
            if (i >= p.length()){
                int prePoint = s.charAt(i-p.length()) - 'a';
                if (windows[prePoint] == need[prePoint]){
                    Count--;
                }
                windows[prePoint]--;
            }
            if (count == Count){
                res.add(i - p.length()+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(new S438().findAnagrams(s, p));
    }
}
