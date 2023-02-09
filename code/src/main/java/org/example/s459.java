package org.example;

public class s459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0){
            return false;
        }
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = -1;
        /**
         * 减1: [0,next[k]]=[k-next[k], j]
         * 不减1：[0,next[k]-1]=[k+1-next[k],k]=[k-(next[k]-1), k]
         */
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)){
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
        if (next[s.length()-1] != -1 && s.length() % (s.length() - (next[s.length() - 1]+1)) == 0){
            return true;
        }
        return false;
    }
}
