package org.example;

public class offer58 {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n-1);
        reverse(sb, n, length-1);
        reverse(sb, 0, length-1);
        return sb.toString();
    }
    public void reverse(StringBuilder sb, int start, int end){
        while (start < end){
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }
}
