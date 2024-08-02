package org.hot100;

import java.util.Arrays;

public class S14 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        if (strs.length == 1){
            return strs[0];
        }
        int index = 0,  n = strs.length;
        while (index < Math.min(strs[0].length(), strs[n-1].length()) &&strs[0].charAt(index) == strs[n-1].charAt(index)){
            index++;
        }
        if (index==0){
            return "";
        }else {
            return strs[0].substring(0, index);
        }
    }
}
