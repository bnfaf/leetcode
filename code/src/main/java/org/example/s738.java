package org.example;

import java.util.ArrayList;
import java.util.List;

public class s738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length()-2; i>= 0; i--){
            if (chars[i]>chars[i+1]){
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args) {
        s738 solution = new s738();
        System.out.println(solution.monotoneIncreasingDigits(120));
    }

}
