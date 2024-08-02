package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class offer44 {
    public List<Integer> largestValues(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();

        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        deque.push(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int value = Integer.MIN_VALUE;
            for (int i = 0; i< size;i++){
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.val > value){
                    value = treeNode.val;
                }
                if (treeNode.left!=null){
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right!=null){
                    deque.addLast(treeNode.right);
                }
            }

            list.add(value);
        }
        return list;
    }
}
