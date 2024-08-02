package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class S763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] position = new int[26];
        for (int i = 0; i<s.length(); i++){
            position[s.charAt(i) - 'a'] = i;
        }
        int pos = 0, last = 0;
        for (int i = 0; i < s.length(); i++){
            pos = Math.max(pos, position[s.charAt(i)-'a']);
            if (pos == i){
                res.add(pos - last+1);
                last = pos+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new S763().partitionLabels(s));
    }
}
