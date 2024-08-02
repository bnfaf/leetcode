package org.example;

import java.util.Arrays;

public class s452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b)->Integer.compare(a[0], b[0]));
        if (points.length == 1) {
            return 1;
        }
        int b = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (b < points[i][0]){
                res += 1;
                b = points[i][1];
            }else{
                b = Math.min(b, points[i][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        s452 solution = new s452();
        int[][] points = new int[][]{
                {10, 116}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(solution.findMinArrowShots(points));
    }
}
