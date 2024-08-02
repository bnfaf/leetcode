package org.example;

import org.jetbrains.annotations.NotNull;
import sun.plugin2.message.transport.SerializingTransport;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class s139 {
    public boolean  wordBreak(@NotNull String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
