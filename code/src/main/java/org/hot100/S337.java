package org.hot100;

import org.example.TreeNode;

public class S337 {

    public int rob(TreeNode root) {
        int[] res = robs(root);

        return Math.max(res[0], res[1]);
    }
    public int[] robs(TreeNode root){
        // 0 偷 1 不偷
        if (root == null){
            return new int[]{0, 0};
        }
        int[] left = robs(root.left);
        int[]  right = robs(root.right);
        int first = root.val + left[1] +  right[1];
        int second = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{first, second};
    }
}
