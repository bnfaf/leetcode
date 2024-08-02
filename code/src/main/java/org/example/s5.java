package org.example;

public class s5 {
    public String longestPalindrome(String s) {
        int maxLen = 1, n = s.length();
        int start = 0;
        boolean[][] dp  = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int len = 2; len <= n; len++){
            for (int i = 0; i < n; i++) {
                int j = i+len-1;
                if (j>=n){
                    break;
                }
                if (s.charAt(i) == s.charAt(j)){
                    if (j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && len > maxLen){
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    public String longestPalindrome2(String s){
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroudCenter(s, i, i);
            int len2 = expandAroudCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // 长度为len
                // 当为(i, i),len为奇数，left = i-(len-1)/2, right = i + (len-1)/2 -> i + len / 2
                // 当为(i,i+1),len为偶数， left = i + 1 - len / 2 = i - (len-2)/2->i-(len-1)/2, right =  i + len / 2
                start = i - (len - 1) / 2;
                end = i + len / 2;

            }
        }
        return s.substring(start, end+1);
    }

    /**
     * 向右延申的步数，
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expandAroudCenter(String s, int left, int right){
        // 当不满足条件时跳出，即有length = right - left - 1
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new s5().longestPalindrome("babad"));
    }
}
