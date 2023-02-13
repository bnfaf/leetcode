package org.example;

import java.util.Stack;

public class s530 {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> res = new Stack<TreeNode>();
        int min = Integer.MAX_VALUE;
        TreeNode cur = root, pre = null;
        while (cur != null || !res.isEmpty()){
            if (cur != null){
                res.push(cur);
                cur = cur.left;
            }else{
                cur = res.pop();
                if (pre != null){
                    min = Math.min(Math.abs(pre.val - cur.val), min);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return min;
    }
}
