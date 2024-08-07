package org.example;

import java.util.Arrays;

public class s1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b)->a[0]-b[0]);
        int mx = 0;
        for (int i = 1; i < points.length; i++) {
            mx = Math.max(mx, points[i][0] - points[i-1][0]);
        }
        return mx;
    }
}
