package org.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class s102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null){
            return res;
        }
        deque.addLast(root);
        while (!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int n = deque.size();
            for (int i = 0; i < n; i++){
                TreeNode treeNode = deque.pollFirst();
                temp.add(treeNode.val);
                if (treeNode.left!=null){
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right!=null){
                    deque.addLast(treeNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
