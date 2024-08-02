package org.example;

import java.util.Arrays;

public class s1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0){
                total += customers[i];
            }
        }
        int increment = 0;
        for (int i = 0; i < minutes; i++) {
            increment += customers[i] * grumpy[i];
        }
        int maxIncrement = increment;
        for (int i = minutes; i < customers.length; i++) {
            increment = increment + customers[i] * grumpy[i] - customers[i-minutes] * grumpy[i-minutes];
            maxIncrement = Math.max(maxIncrement, increment);
        }
        return total + maxIncrement;
    }

    public static void main(String[] args) {
        int[] customers = {5, 8};
        int[] grumpy = {0, 1};
        s1052 solution = new s1052();
        System.out.println(solution.maxSatisfied(customers, grumpy, 1));
    }
}
