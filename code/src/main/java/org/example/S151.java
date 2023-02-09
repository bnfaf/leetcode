package org.example;

import java.util.Arrays;

public class S151 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0){
            return null;
        }
        if (n == 1){
            return new TreeNode(inorder[0]);
        }
        int i;
        for (i = 0; i < n; i++) {
            if (preorder[0] == inorder[i]){
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1),
                Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, n),
                Arrays.copyOfRange(inorder, i+1, n));
        return root;
    }



    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        S151 solution = new S151();
        TreeNode root = solution.buildTree(preorder, inorder);
    }
}
