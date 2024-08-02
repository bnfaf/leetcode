package org.example;

public class S979 {
    int  sum = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return sum;
    }
    public int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum += Math.abs(left) + Math.abs(right); // 解决内部循环问题 从左边提交一部分，分发到右边
        return left + right + root.val -1;  //需要上级转移或给上级转移多少
    }
}
