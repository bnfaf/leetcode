package org.example;

public class s383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i) - 'a'] -= 1;
            if (arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
