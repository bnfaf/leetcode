package org.example;

public class s106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder 中序 post后续
        if (inorder.length == 0){
            return null;
        }
        return buildTree(inorder, postorder, 0, postorder.length-1, 0, postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight,
                              int postLeft, int postRight){
        if (inLeft > inRight || postLeft > postRight){
            return null;
        }
        int index = inLeft;
        for (;index <= inRight; index++){
            if (inorder[index] == postorder[postRight]){
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[index]);
        root.left = buildTree(inorder, postorder, inLeft, index-1, postLeft, postLeft + index-inLeft-1);
        root.right = buildTree(inorder, postorder, index+1, inRight,
                postLeft+index-inLeft, postRight-1);
        return root;
    }

    public static void main(String[] args) {
        s106 solution = new s106();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        solution.buildTree(inorder, postorder);
    }
}
