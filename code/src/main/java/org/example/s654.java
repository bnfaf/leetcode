package org.example;

public class s654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return build(nums, 0, nums.length-1);
    }
    public TreeNode build(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int maxIndex = left;
        for (int i = left; i <=right; i++){
            if (nums[maxIndex] < nums[i]){
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, left, maxIndex-1);
        root.right = build(nums, maxIndex+1, right);
        return root;
    }
}
