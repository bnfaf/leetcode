package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class s1110 {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<Integer> collect = Arrays.stream(to_delete).boxed().collect(Collectors.toList());
        TreeNode travel = travel(root, collect);
        Optional.ofNullable(travel).ifPresent(treeNode -> res.add(treeNode));
        return res;
    }
    public TreeNode travel(TreeNode root, List<Integer> collect){
        if (root==null){
            return null;
        }
        TreeNode left = travel(root.left, collect);
        TreeNode right = travel(root.right, collect);
        if (collect.contains(root.val)){
            Optional.ofNullable(left).ifPresent(treeNode -> res.add(treeNode));
            Optional.ofNullable(right).ifPresent(treeNode -> res.add(treeNode));
            return null;
        }else{
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
