package org.example;

public class s169 {
    public int majorityElement(int[] nums) {
        int pre = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                pre = nums[i];
                count++;
            }else{
                if (pre!=nums[i]){
                    count--;
                }else{
                    count++;
                }
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        s169 solution = new s169();
        System.out.println(solution.majorityElement(nums));
    }
}
