package org.hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S406 {
    public int[][] reconstructQueue(int[][] people) {
        // 解析 将其按照高身高低位次进行排序，再重新填放，假设满足要求，当p=[ai,bi]时，将该元素放到bi位置上，则必有前面元素满足要求

        Arrays.sort(people, (a, b)->{
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> que = new LinkedList<>();
        for (int[] p : people){
            que.add(p[1], p);
        }
        return que.toArray(new int[0][]);
    }
}
