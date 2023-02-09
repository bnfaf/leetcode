package org.example;

public class S543 {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        // 节点数量 - 1
        return result - 1;
    }
    public int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
