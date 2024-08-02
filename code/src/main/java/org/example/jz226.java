package org.example;

public class jz226 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return (root1 != null && root2 != null) && (travel(root1, root2) ||
                HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));
    }
    public boolean travel(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return travel(root1.left, root2.left) && travel(root1.right, root2.right);
    }
}
