package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class S101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }
        LinkedList<TreeNode> ans = new LinkedList<TreeNode>();
        ans.add(root.left);
        ans.add(root.right);
        TreeNode left, right;
        while (ans.size() > 0){
            left = ans.pollFirst();
            right = ans.pollFirst();
            if (left == null && right ==null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            ans.add(left.left);
            ans.add(right.right);
            ans.add(left.right);
            ans.add(right.left);
        }
        return true;
    }
    public boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}
