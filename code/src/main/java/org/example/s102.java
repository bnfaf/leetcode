package org.example;

import javax.swing.event.ListDataListener;

import java.util.*;

public class s102 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        if (root != null) {
            que.add(root);
        }
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                level.add(node.val);
                if (node.left!=null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }


}
