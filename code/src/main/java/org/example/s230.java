package org.example;

public class s230 {
    private int res;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return 0;
        }
        count = 0;
        travel(root, k);
        return res;
    }
    public void travel(TreeNode root, int k){
        if (root == null){
            return;
        }
        travel(root.left, k);
        count++;
        if (count == k){
            res = root.val;
            return;
        }
        travel(root.right, k);

    }
}
