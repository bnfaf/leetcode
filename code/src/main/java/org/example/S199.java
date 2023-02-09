package org.example;

import java.util.*;

public class S199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> ans = new LinkedList<TreeNode>();
        if (root == null) {
            return res;
        }
        ans.add(root);
        while (!ans.isEmpty()){
            TreeNode tmp = ans.peekLast();
            res.add(tmp.val);
            int length = ans.size();
            while (length-->0) {
                tmp = ans.pollFirst();
                if (tmp.left != null) {
                    ans.add(tmp.left);
                }
                if (tmp.right != null) {
                    ans.add(tmp.right);
                }
            }
        }
        return res;
    }
}
