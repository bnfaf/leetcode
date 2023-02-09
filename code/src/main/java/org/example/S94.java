package org.example;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S94 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<Object> stack = new Stack<>();
        if (root == null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (obj instanceof TreeNode) {
                TreeNode node = (TreeNode) obj;
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node.val);
                if (node.left!=null) {
                    stack.push(node.left);
                }
            }else {
                ans.add((Integer) obj);
            }
        }
        return ans;
    }
    public void travel(TreeNode node){
        if(node == null){
            return;
        }
        travel(node.left);
        ans.add(node.val);
        travel(node.right);
    }
}
