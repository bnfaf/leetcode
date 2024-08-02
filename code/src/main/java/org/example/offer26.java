package org.example;

import java.util.*;

public class offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null) && (recurse(A, B) ||  isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public boolean recurse(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        return recurse(A.left, B.left) && recurse(A.right, B.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] nums = new int[m][n];


        System.out.printf("%.2f", 4.236);
    }
}
