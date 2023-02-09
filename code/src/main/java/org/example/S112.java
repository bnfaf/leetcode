package org.example;

/**
 * @author Administrator
 * @Date: 23.1.3
 */
public class S112 {
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, targetSum);
        return result;
    }
    public void dfs(TreeNode root, int targetSum){
        if (root.left == null && root.right == null){
            result = targetSum == root.val ? true : result;
        }
        if (root.left != null ){
            dfs(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val);
        }
    }
}
