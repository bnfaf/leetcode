package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] arr = new int[26];
        Map<String, List<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length;i++){
            for (char c : strs[i].toCharArray()){
                arr[c-'a'] += 1;
            }
            for(int j = 0; j<26;j++){
                sb.append(arr[j]);
                arr[j] = 0;
            }
            List<Integer> integers = map.getOrDefault(sb.toString(), new ArrayList<>());
            integers.add(i);
            map.put(sb.toString(), integers);
            sb.setLength(0);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry:map.entrySet()){
            List<String> list = new ArrayList<>();
            List<Integer> value = entry.getValue();
            value.forEach(x -> {
                list.add(strs[x]);
            });
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        s49 solution = new s49();
        System.out.println(solution.groupAnagrams(strs));
    }

}
