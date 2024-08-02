package org.example;

import java.util.Arrays;

public class s435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        int count = 1, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (end <= intervals[i][0]){
                end = intervals[i][1];
                count++;
            }else{
                end = Math.min(end, intervals[i][1]);
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 100}, {11, 22}, {1, 11}, {2, 12}
        };
        s435 solution = new s435();
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
