package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderTravel {
    private List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> ans = new Stack<TreeNode>();
        ans.push(cur);
        while (!ans.isEmpty()){
            cur = ans.peek();
            if (cur != null){
                ans.pop();
                if (cur.right!= null){
                    ans.push(cur.right);
                }
                if (cur.left != null){
                    ans.push(cur.left);
                }
                ans.push(cur);
                ans.push(null);
            }else{
                ans.pop();
                cur = ans.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

    private List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> ans = new Stack<TreeNode>();
        ans.push(cur);
        while (!ans.isEmpty()){
            cur = ans.peek();
            if (cur != null){
                ans.pop();
                if (cur.right!= null){
                    ans.push(cur.right);
                }
                ans.push(cur);
                ans.push(null);
                if (cur.left != null){
                    ans.push(cur.left);
                }

            }else{
                ans.pop();
                cur = ans.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

    private List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> ans = new Stack<TreeNode>();
        ans.push(cur);
        while (!ans.isEmpty()){
            cur = ans.peek();
            if (cur != null){
                ans.push(null);
                if (cur.right!= null){
                    ans.push(cur.right);
                }
                if (cur.left != null){
                    ans.push(cur.left);
                }

            }else{
                ans.pop();
                cur = ans.pop();
                res.add(cur.val);
            }
        }
        return res;
    }
}
