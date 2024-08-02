package org.hot100;

public class S287 {
    public int findDuplicate(int[] nums) {
        // 数组建环
        // 1 3 4 2 2
        // 0 -> 3 -> 2 -> 4->2 形成环
        int fast = 0, slow = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (nums[fast] != nums[slow]);
        slow = 0;
        while (nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[fast];
    }
}
