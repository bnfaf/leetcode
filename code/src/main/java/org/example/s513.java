package org.example;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class s513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> res = new ArrayDeque<>();
        TreeNode cur ;
        res.push(root);
        int num = 0;
        while (!res.isEmpty()){
            num = res.peekFirst().val;
            System.out.println(num);
            int size =  res.size();
            for (int i = 0; i < size; i++) {
                cur = res.pollFirst();
                if (cur.left != null){
                    res.offerLast(cur.left);
                }
                if (cur.right != null){
                    res.offerLast(cur.right);
                }
            }
        }
        return num;
    }
}
