package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T141 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        TreeNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pollLast();
            if (temp.right != null) {
                stack.addLast(temp.right);
            }
            if (temp.left != null) {
                stack.addLast(temp.left);
            }
            ans.add(temp.val);
        }
        return ans;
    }
}
