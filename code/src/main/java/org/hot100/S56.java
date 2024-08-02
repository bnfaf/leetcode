package org.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b)->{
            return a[0] == b[0] ? a[1] - b[1]: a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        int first = intervals[0][0], second = intervals[0][1];
        for (int i = 1; i<intervals.length; i++){
            if (second < intervals[i][0]){
                res.add(new int[]{first, second});
                first = intervals[i][0];
                second = intervals[i][1];
            }else{
                second = Math.max(intervals[i][1], second);
            }
        }
        res.add(new int[]{first, second});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intern = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(Arrays.deepToString(new S56().merge(intern)));
    }
}
