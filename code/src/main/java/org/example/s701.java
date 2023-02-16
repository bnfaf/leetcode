package org.example;

public class s701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        if (cur == null) {
            return new TreeNode(val);
        }
        while (cur!=null){
            if (cur.val < val){
                if (cur.right == null){
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }else{
                if (cur.left == null){
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
        }
        return root;
    }
}
