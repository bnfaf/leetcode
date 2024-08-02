package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class s496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;  i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        Stack<Integer> ans = new Stack<Integer>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        ans.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] < nums2[ans.peek()]){
                ans.push(i);
            }else{
                while (!ans.isEmpty() && nums2[i] > nums2[ans.peek()]){
                    if (map.containsKey(nums2[ans.peek()])){
                        int index = map.get(nums2[ans.peek()]);
                        res[index] = nums2[i];
                    }
                    ans.pop();
                }
                ans.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        s496 solution = new s496();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[] {1,2, 3, 4};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
    }
}
