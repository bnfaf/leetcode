package org.example;

public class s1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int[] store = new int[26];
        for (int i = 0;i < allowed.length(); i++) {
            Character s = allowed.charAt(i);
            store[s-'a'] = 1;
        }
        Boolean flag;
        for(String word: words){
            flag = true;
            for (int j = 0; j < word.length(); j++) {
                if (store[word.charAt(j)- 'a']==0) {
                    flag = false;
                    break;

                }
            }
            if (flag) {
                res += 1;
            }
        }
        return res;
    }
}
