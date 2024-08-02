package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class s128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1};
        s128 solution = new s128();
        System.out.println(solution.longestConsecutive(nums));
    }
}
