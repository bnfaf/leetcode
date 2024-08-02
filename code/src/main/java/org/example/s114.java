package org.example;

public class s114 {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        flatten(left);
        TreeNode right = root.right;
        flatten(right);
        root.left = null;
        if (left != null){
            TreeNode cur = left;
            while (cur.right != null){
                cur = cur.right;
            }
            root.right = left;
            cur.right = right;
        }
    }
}
