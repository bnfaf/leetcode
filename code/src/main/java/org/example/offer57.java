package org.example;

import java.util.HashMap;
import java.util.Map;

public class offer57 {
    // 使用桶对在一定范围的数字进行放置，从而更好的进行比较，
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

         int n = nums.length;
         // 当桶中已有元素，则为true
         Map<Long, Long> map = new HashMap<>();
         // 桶的大小为t+1,允许的最大最小元素之差为t
         long w = (long) t+1;

         for (int i = 0; i<n;i++){
             // 获取桶号
             long id = getID(nums[i], w);
             // 桶中已有元素，满足要求为true
             if (map.containsKey(id)){
                 return true;
             }
             // 前面的桶有元素，且满足要求
             if (map.containsKey(id-1) && Math.abs(nums[i] - map.get(id-1))<w){
                 return true;
             }
             // 后面的桶有元素，且满足要求
             if (map.containsKey(id+1) && Math.abs(nums[i] - map.get(id+1))<w){
                 return true;
             }
             // 放进去
             map.put(id, (long) nums[i]);
             // 滑窗 去掉不合适的
             if (i >= k){
                 map.remove(getID(nums[i-k], w));
             }
         }
         return false;
    }
    public long getID(long x, long w){
        // 正数，[0, t] 为id为0
        if (x>=0){
            return x/w;
        }
        //负数，[-t-1. -1]归到id为-1
        return (x+1)/w-1;
    }

    public static void main(String[] args) {
        offer57 solution = new offer57();
        int[] nums = {1,5,9,1,5,9};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
