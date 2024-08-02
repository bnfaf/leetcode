package org.hot100;

public class S124 {
    int value = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return value;
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        value = Math.max(value, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
