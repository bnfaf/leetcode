package org.example;

public class S2490 {
    public static boolean isCircularSentence(String sentence) {
        String[] strings = sentence.split(" ");
        for(int i = 0; i < strings.length-1; i++){
            if (strings[i].charAt(strings[i].length()-1)!=strings[i+1].charAt(0)){
                return false;
            }
        }
        return strings[0].charAt(0) == strings[strings.length - 1].charAt(strings[strings.length - 1].length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
    }
}
