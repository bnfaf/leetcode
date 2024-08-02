package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class s6424 {
    public static int semiOrderedPermutation(int[] nums) {
        List<Integer> integerList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int low = integerList.indexOf(1);
        int high = integerList.indexOf(integerList.size());
        return low < high ? low + integerList.size()-1-high : low +integerList.size()-2-high;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3};
        System.out.println(semiOrderedPermutation(nums));
    }
}
