package org.example;

import java.util.*;

public class s127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        int[][] dis = new int[wordList.size()][wordList.size()];
        int[] diss = new int[wordList.size()];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i+1; j < wordList.size(); j++) {
                dis[i][j] = distance(wordList.get(i), wordList.get(j));
                dis[j][i] = dis[i][j];
            }
        }
        boolean[] used = new boolean[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            diss[i] = distance(beginWord, wordList.get(i));
            if (diss[i] <= 1){
                deque.addLast(i);
                used[i] = true;
            }
        }
        int num = 1;

        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                int m = deque.pollFirst();
                if(wordList.get(m).equals(endWord)){
                    return num+1;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (dis[m][i] == 1 && !used[i]){
                        deque.addLast(i);
                        used[i] = true;

                    }
                }
            }
            num += 1;
        }
        return 0;
    }
    public int distance(String begin, String end){
        int sum = 0;
        for (int i= 0; i<begin.length();i++){
            if (begin.charAt(i) != end.charAt(i)){
                sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","tog","cog"));
        s127 solution = new s127();
        System.out.println(solution.ladderLength(begin, end, wordList));

    }
}
