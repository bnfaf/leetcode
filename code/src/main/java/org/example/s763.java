package org.example;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.Collectors;

public class s763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<Integer>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0, last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, edge[chars[i] - 'a']);
            if (i == idx){
                list.add(i - last);
                last = i;
            }
        }
        return list;

    }
}
