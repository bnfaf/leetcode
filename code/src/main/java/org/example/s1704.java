package org.example;




import java.util.Arrays;

import java.util.List;


public class s1704 {
    public boolean halvesAreAlike(String s) {
        Character[] reStrings = {'a', 'e', 'i', 'o', 'u',
                              'A', 'E', 'I', 'O', 'U'};
        final List<Character> strings = Arrays.asList(reStrings);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (strings.contains(s.charAt(i))) {
                if (i < s.length()/2) {
                    res += 1;
                }else {
                    res -= 1;
                }
            }
        }
        return res == 0;
    }
}
