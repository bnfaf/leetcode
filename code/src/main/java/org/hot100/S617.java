package org.hot100;

public class S617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return buildTree(root1, root2);
    }
    public TreeNode buildTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return null;
        } else if (root1!=null && root2 != null) {
            TreeNode root = new TreeNode(root1.val + root2.val);
            root.left = buildTree(root1.left, root2.left);
            root.right = buildTree(root1.right, root2.right);
            return root;
        } else if (root1 == null) {
            return root2;
        }
        return root1;

    }
}
