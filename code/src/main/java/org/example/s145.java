package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class s145 {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root!=null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                stack.push(node);
                stack.push(null);
                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }else{
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
    public void travel(TreeNode root){
        if (root == null){
            return;
        }
        travel(root.left);
        travel(root.right);
        res.add(root.val);
    }
}
