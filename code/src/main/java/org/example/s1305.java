package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class s1305 {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        travel(root1);
        travel(root2);
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return res;
    }
    public void travel(TreeNode root){
        if (root == null){
            return;
        }
        res.add(root.val);
        travel(root.left);
        travel(root.right);
    }
}
