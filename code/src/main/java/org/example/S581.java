package org.example;

public class S581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n < 2){
            return 0;
        }
        int left = -1, max = Integer.MIN_VALUE, right = -1, min = Integer.MAX_VALUE;
        // A B C A 升序 B 乱序  C 升序
        for(int i = 0; i < n; i++){
            if (max > nums[i]){
                right = i;
            }else{
                max = nums[i];
            }
            if (min < nums[n - 1 - i]){
                left = n - 1 - i;
            }else{
                min = nums[n-1-i];
            }
        }
        return right == -1?0:right - left+1;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,3,1,4};
        System.out.println(new S581().findUnsortedSubarray(nums));
    }
}
