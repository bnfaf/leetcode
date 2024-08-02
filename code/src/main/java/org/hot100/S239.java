package org.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++){
            while (!deque.isEmpty() && nums[deque.peekLast()] <nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int index = 0;
        res[index++] = nums[deque.peekFirst()];
        for (int i = k; i<n; i++){
            while (!deque.isEmpty()&&deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while (!deque.isEmpty()&&nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            res[index++] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(new S239().maxSlidingWindow(nums, 3)));
    }
}
