package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class s538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        int sum = 0;
        trans(root, sum);
        return root;
    }
    public int trans(TreeNode root, int num){
        if (root == null){
            return num;
        }
        num = trans(root.right, num);
        System.out.println(num);
        num += root.val;
        root.val = num;
        trans(root.left, num);
        return num;
    }

}
