package org.example;

import java.util.Scanner;

public class strStr {

    public void getNext(String s, int[] next){
        int j = -1;
        next[0]=j;
        for (int i = 1;i<s.length(); i++){
            while (j>=0 && s.charAt(i)!=s.charAt(j+1)){
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }
    public int Str(String s, String t){
        if (t.length() == 0){
            return 0;
        }
        int[] next = new int[t.length()];
        getNext(t, next);
        int j = -1;
        for(int i = 0;i<s.length();i++){
            while (j>=0 && s.charAt(i) != t.charAt(j+1)){
                j = next[j];
            }
            if (s.charAt(i) == t.charAt(j+1)){
                j++;
            }
            if (j == t.length()-1){
                return i-j+1;
            }
        }

        return -1;
    }
}
