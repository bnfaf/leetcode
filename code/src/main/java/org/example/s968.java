package org.example;

public class s968 {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        // 0 无覆盖
        // 1 有摄像头
        // 2 有覆盖
        if (minCame(root) == 0){
            res++;
        }
        return res;

    }
    public int minCame(TreeNode root){
        if (root == null){
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);
        if (left == 2 && right == 2){
            return 0;
        }else if (left == 0 || right == 0){
            res++;
            return 1;
        }else{
            return 2;
        }
    }
}
