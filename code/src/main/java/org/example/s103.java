package org.example;

import java.util.*;

/**
 * @author Administrator
 */
public class s103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root==null) {
            return res;
        }
        LinkedList<TreeNode> store = new LinkedList<TreeNode>();
        store.add(root);
        int level = 0;
        while (!store.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            int len = store.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = store.poll();
                if (level % 2 == 0) {
                    temp.addLast(node.val);
                }else {
                    temp.addFirst(node.val);
                }
                if (node.left!=null) {
                    store.add(node.left);
                }
                if (node.right!=null) {
                    store.add(node.right);
                }
            }
            res.add(temp);
            level += 1;
        }
        return res;
    }
}
