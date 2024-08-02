package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

import java.util.*;

public class offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        deque.add(root);
        boolean flag = true;
        TreeNode temp;
        while (deque.size()>0){
            Deque<Integer> level = new LinkedList<Integer>();
            int size = deque.size();
            for (int i = 0;i<size;i++){
                temp = deque.pollFirst();
                if (flag){
                    level.addLast(temp.val);
                }else{
                    level.addFirst(temp.val);
                }
                if (temp.left!=null){
                    deque.addLast(temp.left);
                }
                if (temp.right!=null){
                    deque.addLast(temp.right);
                }
            }
            res.add((List<Integer>) level);
            flag = !flag;
        }
        return res;
    }
}
