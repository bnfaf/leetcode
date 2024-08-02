package org.example;

public class s2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        for (int i = 0; i <= nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                if (nums[j] - nums[i] == diff){
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[k] - nums[j] == diff){
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        s2367 solution = new s2367();
        int[] nums = {0,1,4,6,7,10};
        System.out.println(solution.arithmeticTriplets(nums, 3));
    }
}
