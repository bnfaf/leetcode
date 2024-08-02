package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

public class offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight,
                          int inLeft, int inRight){
        if (preLeft > preRight || inLeft  > inRight){
            return null;
        }
        int index = inLeft;
        while (index <= inRight && preorder[preLeft] != inorder[index]){
            index+=1;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        node.left = build(preorder, inorder, preLeft+1,  index-inLeft+preLeft, inLeft, index-1);
        node.right = build(preorder, inorder, index-inLeft+preLeft+1, preRight, index+1, inRight);
        return node;
    }
}
