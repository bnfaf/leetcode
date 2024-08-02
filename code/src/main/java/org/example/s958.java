package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class s958 {
    int size;
    int maxCode = 0;
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        boolean flag = false;
        while (!deque.isEmpty()){
            TreeNode temp = deque.pollFirst();
            if (flag && (temp.left != null || temp.right != null) ){
                return false;
            }
            if (temp.left != null && temp.right == null){
                flag = true;
                deque.addLast(temp.left);
            }else if (temp.left == null && temp.right != null){
                return false;
            }else if (temp.left != null){
                deque.addLast(temp.left);
                deque.addLast(temp.right);
            }else {
                flag = true;
            }
        }
        return true;
    }
    public void travle(TreeNode root, int index){
        if (root == null){
            return;
        }
        size++;
        maxCode = Math.max(maxCode, index);
        travle(root.left, index * 2);
        travle(root.right, index*2+1);

    }
}
