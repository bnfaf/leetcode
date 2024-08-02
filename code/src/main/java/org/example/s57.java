package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class s57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<int[]>();
        int left = newInterval[0], right = newInterval[1];
        boolean flag = false;
        for (int[] interval : intervals){
            if (interval[0] > right){
                if (!flag){
                    flag = true;
                    res.add(new int[]{left, right});
                }
                res.add(interval);
            } else if (left > interval[1]) {
                res.add(interval);
            }else{
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!flag){
            res.add(new int[] {left, right});
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] inter = {
                {1, 5}, {2, 3}
        };
        s57 solution = new s57();
        int[] newInter = {2, 5};
        System.out.println(Arrays.deepToString(solution.insert(inter, newInter)));
    }
}
