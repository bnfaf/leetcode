package org.example;

public class s5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1, begin = 0;

        // 创建dp矩阵
        boolean[][] dp = new boolean[len][len];
        // i-i必定可回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 字符串长度
        for (int L=2; L <= len; L++) {
            //左边界
            for (int i = 0; i < len; i++) {
                // 右边界
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i]!=charArray[j]) {
                    dp[i][j] = false;
                }else {
                    // l-1<3-> l<4 -> l=3, 2, 1
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && L> maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
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
}
