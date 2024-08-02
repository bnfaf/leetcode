package org.example;

import java.util.HashMap;
import java.util.Map;

public class s437 {
    int sum = 0;
    Map<Long, Integer> map = new HashMap<>();
    int ans , t;
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        if (root == null){
            return 0;
        }
        map.put(0L, 1);
        dfs1(root, root.val);
        return ans;
    }
    public void dfs1(TreeNode root, long val){
        if (map.containsKey(val - t)){
            ans += map.get(val-t);
        }
        map.put(val, map.getOrDefault(val, 0)+1);
        if (root.left!=null){
            dfs1(root.left, val + root.left.val);
        }
        if (root.right!=null){
            dfs1(root.right, val + root.right.val);
        }
        map.put(val, map.getOrDefault(val, 0)-1);
    }
    public void travel(TreeNode root, int targetSum){
        if (root == null){
            return;
        }
        dfs(root, targetSum);
        travel(root.left,  targetSum);
        travel(root.right, targetSum);
    }
    public void dfs(TreeNode root, long target){
        if (target == root.val){
            sum += 1;
        }
        if (root.left!=null){
            dfs(root.left, target - root.val);
        }
        if (root.right != null){
            dfs(root.right, target - root.val);
        }
    }

    public static void main(String[] args) {
        int[] roots = {10,5,-3,3,2,-1,11,3,-2,-1,1};
        TreeNode root = new TreeNode(roots[0]);

    }

}
