package org.example;

public class s450 {
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) {
            return null;
        }
        if (root.val == key){
            if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else{
                TreeNode cur = root.left;
                while (cur.right != null){
                    cur = cur.right;
                }
                cur.right = root.right;
                return root.left;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
