package org.example;

import java.util.*;

public class s850 {
    public int rectangleArea(int[][] rectangles) {
        final  int mod = 1000000007;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < rectangles.length; i++) {
            set.add(rectangles[i][0]);
            set.add(rectangles[i][2]);
        }
        List<Integer> list = new ArrayList<Integer>(set);
        list.sort((a, b) ->{
            return a-b;
        });
        long ans = 0;
        for (int i = 1; i < list.size(); i++){
            int a = list.get(i-1), b = list.get(i), len = b - a;
            List<int[]> infos = new ArrayList<int[]>();
            for (int[] info: rectangles){
                if (info[0]<=a && info[2]>= b){
                    infos.add(new int[] {info[1], info[3]});
                }
            }
            infos.sort((l1, l2)->{
                return l1[0] !=l2[0] ? l1[0]-l2[0] : l1[1] - l2[1];
            });
            long res = 0, l = -1, r = -1;
            for (int[] info : infos){
                if (info[0] > r){
                    res += r - l;
                    l = info[0];
                    r = info[1];
                }else if (r < info[1]){
                    r = info[1];
                }
            }
            res += r - l;
            ans += res * len;
            ans %= mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {

    }
}
