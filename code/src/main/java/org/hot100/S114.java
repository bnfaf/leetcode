package org.hot100;

public class S114 {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        root.left = null;

        if (left != null){
            root.right = left;
            while (left.right!=null){
                left = left.right;
            }
            left.right = right;
        }
    }
}
