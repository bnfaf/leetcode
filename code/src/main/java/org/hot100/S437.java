package org.hot100;

import java.util.HashMap;
import java.util.Map;

public class S437 {
    Map<Long, Integer> map = new HashMap<>();
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return count;
        }
        map.put(0L, 1);
        dfs(root, targetSum, 0L);
        return count;
    }
    public void dfs(TreeNode root, int targetSum, long sum){
        if (root == null){
            return;
        }
        long val = sum+ root.val;
        if (map.containsKey(val - targetSum)){
            count += map.get(val - targetSum);
        }
        map.put(val, map.getOrDefault(val, 0)+1);
        dfs(root.left, targetSum, val);
        dfs(root.right, targetSum, val);
        map.put(val, map.getOrDefault(val, 0)-1);
    }
}
