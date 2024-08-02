package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class s99 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;
        while (!deque.isEmpty() && root != null){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (pred != null && root.val < pred .val){
                y = root;
                if (x == null){
                    x = pred;
                }else{
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        if (x != null && y != null){
            swap(x, y);
        }
    }
    public int putGems(int[] prices, int k){
        int n = prices.length;
        if (n<=k){
            return 0;
        }
        int[] values = new int[n-1];
        for (int i = 1; i < n; i++) {
            values[i-1] = prices[i] + prices[i-1];
        }
        Arrays.sort(values);
        int ans = 0, ans1 = 0;
        for (int i = 0; i < k-1; i++){
            ans += values[i];
        }
        for (int i = n-2;i>n-1-k;i--){
            ans1 += values[i];
        }
        return ans1 - ans;
    }
    public void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    public static void main(String[] args) {
        s99 solution = new s99();
        int[] nums = {2, 3, 5, 4};
        System.out.println(solution.putGems(nums, 2));
    }
}
