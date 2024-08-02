package org.example;

import java.util.ArrayList;
import java.util.List;

public class S438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() < p.length()){
            return res;
        }
        int[] arr = new int[26];
        int count = 0;
        for(char c: p.toCharArray()){
            arr[c - 'a'] += 1;
            if (arr[c - 'a'] == 1){
                count++;
            }
        }
        int[] arr1 = new int[26];
        int Count = 0;
        for (int i = 0; i<s.length(); i++){
            arr1[s.charAt(i) - 'a']++;
            if (arr[s.charAt(i) - 'a'] == arr1[s.charAt(i) - 'a']){
                Count++;
            }
            if (i >= p.length()){
                arr1[s.charAt(i - p.length()) - 'a']--;
                if (arr1[s.charAt(i - p.length()) - 'a'] == arr[s.charAt(i-p.length())-'a']-1){
                    Count--;
                }
            }
            if (count == Count){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new S438().findAnagrams("cbaebabacd", "abc"));
    }
}
