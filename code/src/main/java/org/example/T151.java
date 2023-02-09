package org.example;

/**
 * @author Administrator
 */
public class T151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1, i = 0;
        while (j >= 0){
            while (j >= 0 &&' ' == s.charAt(j)){
                j--;
            }
            i = j;
            while (i >= 0 && ' ' != s.charAt(i)){
                i--;
            }
            sb.append(s.substring(i+1, j+1));
            sb.append(' ');
            j = i;
        }
        while (' ' == sb.charAt(sb.length() - 1)){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T151 solution = new T151();
        final String s = "  hello world  ";
        System.out.println(solution.reverseWords(s));
    }
}
