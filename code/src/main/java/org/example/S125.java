package org.example;

public class S125 {
    public static boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        int i = 0, j = lower.length()-1;
        while (i < j) {
            while (i < lower.length() && !Character.isDigit(lower.charAt(i)) && !Character.isLetter(lower.charAt(i)) ){
                i++;
            }
            while ( j > 0 &&!Character.isDigit(lower.charAt(j)) && !Character.isLetter(lower.charAt(j))){
                j--;
            }

            if (i <= j && lower.charAt(i) != lower.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }
}
