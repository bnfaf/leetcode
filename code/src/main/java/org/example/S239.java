package org.example;

import java.util.*;

public class S239{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() >= k ){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            res[index++] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        S239 solution = new S239();
        int[] nums = new int[]{1, -1};
        Arrays.stream(solution.maxSlidingWindow(nums, 1)).forEach(System.out::println);
    }
}
