package org.example;

import java.util.*;

public class s2070 {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
       for (int[] item: items){
           if (!map.containsKey(item[0]) || map.get(item[0]) < item[1]){
               map.put(item[0], item[1]);
           }
       }
        NavigableSet<Integer> integers = map.navigableKeySet();
       int pre = 0;
       for(int key : integers){
           if (pre == 0 || pre < map.get(key)){
               pre = map.get(key);
           }else if (pre > map.get(key)) {
               map.put(key, pre);
           }
       }
        int[] ans = new int[queries.length];
       for (int i = 0; i < queries.length; i++) {
           int query = queries[i];
           Map.Entry<Integer, Integer> entry = map.floorEntry(query);
           int finalI = i;
           Optional.ofNullable(entry).ifPresent(e -> ans[finalI]=e.getValue());
//           if (entry != null){
//               ans[i] = entry.getValue();
//           }
       }
       return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {193,732}, {781,962}, {864,954}, {749,627}, {136,746}, {478,548}, {640,908}, {210,799}, {567,715}, {914,388},
                {487,853}, {533,554}, {247,919}, {958,150}, {193,523}, {176,656}, {395,469}, {763,821}, {542,946}, {701,676}
        };
        int[] query = new int[]{885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
        System.out.println(Arrays.toString(maximumBeauty(nums, query)));
    }
}
