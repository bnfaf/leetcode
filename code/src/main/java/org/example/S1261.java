package org.example;

public class S1261 {
    public TreeNode root;
    public void SolveElements(TreeNode root){
        this.root = root;
        solve(root, 0);
    }
    public void solve(TreeNode root, int val){
        if(root == null){
            return;
        }

        root.val = val;
        if (root.left != null){
            solve(root.left, val * 2 + 1);
        }
        if (root.right != null){
            solve(root.right, val * 2 + 2);
        }
    }
    public boolean find(int target){
        if (target < 0){
            return false;
        } else{
            TreeNode cur = root;
            return findElements(target, cur);
        }

    }
    public boolean findElements(int target, TreeNode cur){
        if (cur == null || cur.val > target){
            return false;
        }
        if (cur.val == target){
            return true;
        }
        return findElements(target, cur.left) | findElements(target, cur.right);
    }

}
