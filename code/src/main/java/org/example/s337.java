package org.example;

public class s337 {

    public int rob(TreeNode root) {
        int[] res = robs(root);
        return Math.max(res[0], res[1]);
    }
    public int[] robs(TreeNode root){
        // 节点有两个状态，偷，不偷，0 代表不偷，1 代表偷
        int[] res = new int[2];
        if (root == null){
            return res;
        }
        int[] left = robs(root.left);
        int[] right = robs(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;

    }
}
