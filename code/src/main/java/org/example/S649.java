package org.example;

import sun.awt.TracedEventQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class S649 {
    public static String predictPartyVictory(String senate) {
       int n = senate.length();
        Queue<Integer> radient = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R'){
                radient.add(i);
            }else{
                dire.add(i);
            }
        }
        while (!radient.isEmpty() && !dire.isEmpty()){
            int radientIndex = radient.poll();
            int direIndex = dire.poll();
            if (radientIndex < direIndex){
                radient.offer(radientIndex+n);
            }else{
                dire.offer(direIndex+n);
            }
        }
        return !radient.isEmpty() ? "Radiant" : "Dire";

    }

    public static void main(String[] args) {
        double b1 = Double.parseDouble("0.30");
        double b2 = Double.parseDouble("0.1") * 3;
        System.out.println(b1 == b2);
    }
}
