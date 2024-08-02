package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class s2476 {
    List<Integer> pre = new ArrayList<Integer>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        travel(root);
        System.out.println(pre);
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries){
            res.add(Arrays.stream(binarySearch(query)).boxed().collect(Collectors.toList()));
        }
        return res;
    }
    public void travel(TreeNode root){
        if (root == null){
            return;
        }
        travel(root.left);
        pre.add(root.val);
        travel(root.right);
    }
    public int[] binarySearch(int value){
        int left = 0, right = pre.size();

        while (left < right-1){
            int mid = (left + right) / 2;
            if (pre.get(mid) > value){
                right = mid;
            } else if (pre.get(mid) < value) {
                left = mid;
            }else{
                return new int[]{pre.get(mid), pre.get(mid)};
            }
        }
        if (pre.get(left) == value){
            return new int[]{pre.get(left), pre.get(left)};
        }
        return new int[] {pre.get(left), pre.get(right)};
    }

    public static void main(String[] args) {

    }
}
