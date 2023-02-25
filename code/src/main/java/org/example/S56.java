package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1){
            return new int[0][2];
        }
        Arrays.sort(intervals, (a, b)  -> {
            if (a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }else{
                return Integer.compare(a[0], b[0]);
            }
        });
        int L = intervals[0][0], R = intervals[0][1];
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 1; i < intervals.length; i++) {
            if (R >= intervals[i][0]){
                R = Math.max(intervals[i][1], R);
            }else{
                merged.add(new int[]{L, R});
                L = intervals[i][0];
                R = intervals[i][1];
            }
        }
        merged.add(new int[]{L, R});
        return merged.toArray(new int[merged.size()][]);

    }
}
