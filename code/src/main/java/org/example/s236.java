package org.example;

/**
 * @author Administrator
 */
public class s236 {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root ==null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
    public boolean  travel(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) {
            return false;
        }
        boolean lson = travel(root.left, p, q);
        boolean rson = travel(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val||root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
