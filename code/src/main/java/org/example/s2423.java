package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.*;
import java.util.stream.Collectors;

public class s2423 {
    public boolean equalFrequency(String word) {
        if (word.length() == 1){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
        }
        List<Integer> list = map.values().stream().map(Integer::valueOf).collect(Collectors.toList());
        list.sort((a, b) -> {
            return a-b;
        });
        if (list.size() == 1){
            return true;
        }
        Integer remove = list.remove(0);
        if (remove == 1 && new HashSet<>(list).size() == 1){
            return true;
        }
        list.add(0, remove);
        Integer remove1 = list.remove(list.size() - 1);
        if (list.get(list.size() - 1) == remove1-1 && new HashSet<>(list).size() == 1){
            return true;
        }
        return false;


    }

    public static void main(String[] args) {
        String word = "abcc";
        s2423 solution = new s2423();
        System.out.println(solution.equalFrequency(word));
    }
}
