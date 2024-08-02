package org.hot100;

import java.util.Arrays;

public class S621 {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for (char c : tasks){
            hash[c - 'A'] += 1;
        }
        Arrays.sort(hash);
        int minLen = (n+1) * (hash[25]-1)+1;
        for (int i = 24;i>=0; i--){
            if (hash[i] == hash[25]){
                minLen++;
            }
        }
        return Math.max(minLen, tasks.length);
    }
}
