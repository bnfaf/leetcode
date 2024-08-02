package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>(Arrays.asList(1));
        List<Integer> cur = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j) + pre.get(j - 1));
            }
            cur.add(1);
            pre.clear();
            pre.addAll(cur);
            cur.clear();
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
