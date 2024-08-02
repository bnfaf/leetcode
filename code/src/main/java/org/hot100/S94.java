package org.hot100;

import java.util.*;

public class S94 {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root==null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if (treeNode!=null){
                if (treeNode.right!=null){
                    stack.push(treeNode.right);
                }
                stack.push(treeNode);
                stack.push(null);
                if (treeNode.left!=null){
                    stack.push(treeNode.left);
                }
            }else {
                TreeNode node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
