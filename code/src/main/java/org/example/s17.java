package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s17 {
    List<String> res = new ArrayList<>();
    Map<Character, String[]> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return res;
        }
        map.put('2', new String[] {"a", "b", "c"});
        map.put('3', new String[] {"d", "e", "f"});
        map.put('4', new String[] {"g", "h", "i"});
        map.put('5', new String[] {"j", "k", "l"});
        map.put('6', new String[] {"m", "n", "o"});
        map.put('7', new String[] {"p", "q", "r", "s"});
        map.put('8', new String[] {"t", "u", "v"});
        map.put('9', new String[] {"w", "x", "y", "z"});
        backend(digits, 0);
        return res;
    }
    public void backend(String digits, int k){
        if (digits.length() == k){
            res.add(sb.toString());
            return;
        }
        String[] tmp = map.get(digits.charAt(k));
        for (int i = 0; i < tmp.length; i++) {
            sb.append(tmp[i]);
            backend(digits, k+1);
            sb.deleteCharAt(i);
        }

    }
}
