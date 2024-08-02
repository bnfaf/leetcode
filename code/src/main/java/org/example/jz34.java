package org.example;

import java.util.ArrayList;

public class jz34 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        ArrayList<Integer> temp = new ArrayList<>();
        if (root == null){
            return res;
        }
        travel(root, expectNumber, temp);
        return res;
    }
    public void travel(TreeNode root, int expectNumber, ArrayList<Integer> temp){
        if (root.left == null && root.right == null){
            if (expectNumber == root.val){
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val);
        if (root.left!=null){
            travel(root.left, expectNumber - root.val, temp);
        }
        if (root.right != null){
            travel(root.right, expectNumber - root.val, temp);
        }
        temp.remove(temp.size()-1);
    }
}
