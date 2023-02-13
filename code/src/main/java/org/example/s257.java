package org.example;

import java.util.ArrayList;
import java.util.List;

public class s257 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> sb = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        travel(root, sb);
        return res;
    }
    public void travel(TreeNode root, List<Integer> sb){
        sb.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < sb.size()-1; i++) {
                key.append(sb.get(i)).append("->");
            }
            key.append(sb.get(sb.size() - 1));
            res.add(key.toString());
            sb.remove(sb.size() - 1);
            return;
        }
        if (root.left != null){
            travel(root.left, sb);
        }
        if (root.right != null) {
            travel(root.right, sb);
        }
        sb.remove(sb.size() - 1);

    }
}
