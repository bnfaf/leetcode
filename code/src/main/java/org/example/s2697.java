package org.example;

public class s2697 {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) < s.charAt(s.length()-1-i)){
                sb.setCharAt(sb.length()-1-i, sb.charAt(i));
            }else {
                sb.setCharAt(i, s.charAt(s.length()-1-i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new s2697().makeSmallestPalindrome("egcfe"));
    }
}
