package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class S771 {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(char c : jewels.toCharArray()){
            set.add(c);
        }
        for(char c : stones.toCharArray()){
            if (set.contains(c)){
                count++;
            }
        }
        return count;
    }
}
