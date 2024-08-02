package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class s1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        List<Integer> collect = map.values().stream().mapToInt(Integer::intValue).sorted().boxed().collect(Collectors.toList());
        for (int i = 0; i < collect.size()-1;i++) {
            if (collect.get(i).equals(collect.get(i + 1))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        s1207 solution = new s1207();
        int[] arr = new int[]{1, 2, 2, 1,1,3};
        System.out.println(solution.uniqueOccurrences(arr));
    }
}
