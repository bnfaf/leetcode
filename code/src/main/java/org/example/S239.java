package org.example;

import java.util.*;

public class S239{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] ints, int[] t1) {
//                return ints[0] != t1[0] ? t1[0] - ints[0] : t1[0] - ints[0];
//            }
//        });
//        int[] ans = new int[n-k+1];
//        for (int i = 0; i < k; i++) {
//            pq.offer(new int[] {nums[i], i});
//        }
//        for (int i = k; i < n; i++) {
//            pq.offer(new int[] {nums[i], i});
//            while (pq.peek()[1] <= i-k){
//                pq.poll();
//            }
//            ans[i-k+1] = pq.peek()[0];
//        }
//        return ans;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n-k+1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            // 清除次优
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            // 将现有元素入队
            deque.offerLast(i);
            // 除去过于靠前的元素
            while (deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        S239 solution = new S239();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        Arrays.stream(solution.maxSlidingWindow(nums, 3)).forEach(System.out::println);
    }
}
