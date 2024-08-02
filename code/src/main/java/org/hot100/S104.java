package org.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class S104 {
    public int maxDepth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        return Math.max(left, right)+1;
        int depth = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null){
            return depth;
        }
        deque.addLast(root);
        while (!deque.isEmpty()){
            depth++;
            int n = deque.size();
            while (n-->0){
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left!=null){
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.addLast(treeNode.right);
                }
            }
        }
        return depth;
    }
}
