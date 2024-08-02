package org.example;

import java.util.Arrays;

public class S2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int avg = skill[0] + skill[skill.length - 1];
        long count = 0;
        int left = 0, right = skill.length-1;
        while (left < right){
            if (skill[left] + skill[right] != avg){
                return -1;
            }
            count += ((long) skill[left++] * skill[right--]);
        }
        return count;
    }
}
