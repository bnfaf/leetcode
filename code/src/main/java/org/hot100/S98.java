package org.hot100;

public class S98 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return travel(root);
    }
    public boolean travel(TreeNode root){
        if (root == null){
            return true;
        }
        boolean travel = travel(root.left);
        if (!travel || pre >= root.val){
            return false;
        }
        pre = root.val;
        return travel(root.right);
    }

    public boolean dfs(TreeNode root, Long left, Long right){
        if (root==null){
            return true;
        }
        if (root.val <= left || root.val >= right){
            return false;
        }
        return dfs(root.left, left, (long) root.val) & dfs(root.right, (long) root.val, right);
    }
}
