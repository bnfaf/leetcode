package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s863 {
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    ArrayList<Integer> res = new ArrayList<Integer>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findAns(target, null, 0, k);
        return res;
    }
    public void findParents(TreeNode root){
        if (root.left!=null){
            parents.put(root.left.val, root);
            findParents(root.left);
        }
        if (root.right != null){
            parents.put(root.right.val, root);
            findParents(root.right);
        }
    }
    public void findAns(TreeNode root, TreeNode from, int depth, int k){
        if (root == null){
            return;
        }
        if (depth == k){
            res.add(root.val);
            return;
        }
        if (root.left != from){
            findAns(root.left, root, depth+1, k);
        }
        if (root.right!=from){
            findAns(root.right, root, depth + 1, k);
        }
        if (parents.get(root.val) != from){
            findAns(parents.get(root.val), root, depth + 1, k);
        }
    }
}
