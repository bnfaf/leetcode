package org.example;

import java.util.HashSet;
import java.util.Set;

public class s1016 {
    public boolean queryString(String s, int n) {
//        Set<Integer> seen = new HashSet<Integer>();
//        for(int i = 0; i < s.length(); i++){
//            if (s.charAt(i) == '0'){
//                continue;
//            }
//            int j = i + 1;
//            int x = s.charAt(i) - '0';
//            while (x <= n){
//                seen.add(x);
//                if (j == s.length()){
//                    break;
//                }
//                x = (x << 1) | (s.charAt(j) - '0');
//                j += 1;
//            }
//        }
//        return seen.size() == n;
        for (int i = n; i > 0; i--){
            if (!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
}
