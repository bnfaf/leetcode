package org.hot100;

public class S169 {
    public int majorityElement(int[] nums) {
        int pre = 0, count = 0;
        for (int num : nums){
            if (count == 0){
                count++;
                pre = num;
            }else{
                if (pre == num){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return pre;
    }
}
