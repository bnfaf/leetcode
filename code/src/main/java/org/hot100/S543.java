package org.hot100;

public class S543 {
    int value = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return value;
        }
        dfs(root);
        return value;
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        value = Math.max(value, left + right);
        return Math.max(left, right)+1;
    }
}
