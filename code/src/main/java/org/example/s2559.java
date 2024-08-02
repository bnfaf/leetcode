package org.example;

import javafx.scene.effect.SepiaTone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s2559 {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        List<Character> ans = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] res = new int[queries.length];
        int[] sum = new int[words.length+1];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (ans.contains(word.charAt(0)) && ans.contains(word.charAt(word.length()-1))){
                sum[i+1] = sum[i] + 1;
            }else{
                sum[i+1] = sum[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = sum[query[1]+1] - sum[query[0]];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }
}
