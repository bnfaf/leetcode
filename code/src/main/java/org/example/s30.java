package org.example;

import java.util.*;

public class s30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < w; i++){
            Map<String, Integer> temp = new HashMap<>();
            for (int j = i; j+w<n;j+=w){
                String cur = s.substring(j, j+w);
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                if (j >= i + m *w){
                    int k = j - m*w;
                    String prev = s.substring(k, k+w);
                    if (temp.get(prev) == 1){
                        temp.remove(prev);
                    } else if (temp.containsKey(prev)) {
                        temp.put(prev, temp.get(prev)-1);
                    }
                    if (!map.getOrDefault(prev, 0).equals(temp.getOrDefault(prev, 0))){
                        continue;
                    }
                }
                if (!map.getOrDefault(cur, 0).equals(temp.getOrDefault(cur, 0))){
                    continue;
                }
                if (map.equals(temp)){
                    ans.add(j - (m-1)*w);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        s30 solution = new s30();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(solution.findSubstring(s, words));
    }
}
