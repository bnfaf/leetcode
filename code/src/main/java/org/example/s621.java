package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

public class s621 {
    int res = Integer.MAX_VALUE;
    public int leastInterval(char[] tasks, int n) {
        // 统计每个任务出现的次数，找到出现次数最多的任务
        int[] hash = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            hash[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(hash);
        // 相同元素必须有n个冷却时间，假设A出现3次，n=2,至少形成 AXX AXX A的格局
        int minLen = (n+1) * (hash[25]-1)+1;
        // 剩余任务插入，若X未被占完，
        // 1. 与A次数相同，依次插入 ABX ABX AB len+1
        // 2. 次数少，直接插入即可  ABC ABC AB
        for (int i = 24;i>=0;i--){
            if (hash[i] == hash[25]){
                ++minLen;
            }
        }
        // 已经形成 ABC ABC AB的格局，仍有两次D未插入，可以插入之间，成为 ABCD ABCD AB len为task的长度
        return Math.max(minLen, tasks.length);
    }


}
