package org.example;

public class s404 {
    public int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        traverse(root, false);
        return sum;
    }
    public void traverse(TreeNode root, boolean flag){
        if (root.left == null && root.right == null){
            if (flag){
                sum += root.val;
            }
        }
        if (root.left != null){
            traverse(root.left, true);
        }
        if (root.right != null){
            traverse(root.right, false);
        }
    }

}
