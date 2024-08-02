package org.example;

public class s860 {
    public boolean lemonadeChange(int[] bills) {
        int[] counts = new int[]{0, 0};
        for (int bill : bills) {
            if (bill == 5) {
                counts[0]++;
            } else if (bill == 10) {
                if (counts[0] < 0) {
                    return false;
                }
                counts[0]--;
                counts[1]++;
            } else {
                if (counts[0] > 0 && counts[1] > 0) {
                    counts[0]--;
                    counts[1]--;
                } else if (counts[0] >= 3) {
                    counts[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
