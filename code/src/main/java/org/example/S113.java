package org.example;

import java.util.ArrayList;
import java.util.List;

public class S113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return res;
        }
        travel(root, new ArrayList<>(), 0, targetSum);
        return res;
    }
    public void travel(TreeNode root, List<Integer> tmp, int Sum, int targetSum){
        if (root.left == null && root.right == null){
            tmp.add(root.val);
            Sum += root.val;
            if (Sum == targetSum){
                res.add(new ArrayList<>(tmp));
            }
            tmp.remove(tmp.size()-1);
            return;
        }
        tmp.add(root.val);
        if (root.left != null){
            travel(root.left, tmp, Sum + root.val, targetSum);
        }
        if (root.right != null){
            travel(root.right, tmp, Sum + root.val, targetSum);
        }
        tmp.remove(tmp.size()-1);
    }
}
