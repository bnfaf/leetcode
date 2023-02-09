package org.example;

public class S98 {
    public boolean isValidBST(TreeNode root) {
        return travel(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean travel(TreeNode root, long lower, long upper){
        if (root == null){
            return true;
        }
        if (root.val <= lower || root.val >= upper){
            return false;
        }
        return travel(root.left, lower, root.val) && travel(root.right, root.val, upper);

    }
}
