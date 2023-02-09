package org.example;

import java.util.Stack;

public class S129 {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null){
            return ans;
        }
        travel(root, 0);
        return ans;
    }

    public void travel(TreeNode root, int num){
        if (root.left == null && root.right == null){
            ans += (num * 10 + root.val);
            return;
        }
        System.out.println(num);
        if (root.left != null) {
            travel(root.left, num * 10 + root.val);
        }
        if (root.right != null) {
            travel(root.right, num * 10+root.val);
        }
    }

}
