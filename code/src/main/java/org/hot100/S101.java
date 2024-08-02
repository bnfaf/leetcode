package org.hot100;

public class S101 {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null){
            return true;
        }
        return compare(root.left, root.right);

    }
    public boolean compare(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return compare(left.left, right.right) & compare(left.right, right.left);
    }
}
