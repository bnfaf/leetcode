package org.hot100;

public class S538 {
    int pre = Integer.MIN_VALUE;
    public TreeNode convertBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.right != null || pre != Integer.MIN_VALUE) {
            dfs(root.right);
            root.val += pre;
        }
        pre = root.val;
        dfs(root.left);
    }
}
