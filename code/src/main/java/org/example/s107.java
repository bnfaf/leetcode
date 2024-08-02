package org.example;

import java.util.*;

public class s107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            while (size-->0){
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left!=null){
                    deque.add(node.left);
                }
                if (node.right!=null){
                    deque.add(node.right);
                }
            }
            list.add(temp);
        }
        Collections.reverse(list);
        return list;
    }
}
