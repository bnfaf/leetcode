package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class s6462 {
    public int minimizedStringLength(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        return list.size();
    }

}
