package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class s222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> res = new ArrayDeque<>();
        int count = 0;
        res.push(root);
        TreeNode cur;
        while (!res.isEmpty()){
            int size = res.size();
            count += size;
            while (size-- >0){
                cur = res.pollFirst();
                if (cur.left != null) {
                    res.push(cur.left);
                }
                if (cur.right != null){
                    res.push(cur.right);
                }
            }
        }
        return count;
    }
}
