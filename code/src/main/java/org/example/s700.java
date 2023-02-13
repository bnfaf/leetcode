package org.example;

public class s700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null && cur.val != val){
            if (cur.val > val){
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            }
        }
        return cur;
    }
}
