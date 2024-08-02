package org.example;

public class s2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0, pre = 0, cur = 0;
        for (int i = 0; i < s.length(); i++){
            cur ++;
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i+1)){
                if (s.charAt(i) == '1'){
                    ans = Math.max(ans, Math.min(pre, cur) * 2);

                }
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }
}
