package org.example;

public class s1375 {
    public static int numTimesAllBlue(int[] flips) {
        int mx = 0, res = 0;
        for (int i = 0; i < flips.length; i++) {
            mx = Math.max(mx, flips[i]);
            if (mx == i+1){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] flips = new int[]{4, 1, 2, 3};
        System.out.println(numTimesAllBlue(flips));
    }
}
