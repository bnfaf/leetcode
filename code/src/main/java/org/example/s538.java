package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class s538 {
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        sum = 0;
        trans(root);
        return root;
    }
    public void trans(TreeNode root){
        if (root == null) {
            return;
        }
        trans(root.right);
        sum += root.val;
        root.val = sum;
        trans(root.left);
    }

}
