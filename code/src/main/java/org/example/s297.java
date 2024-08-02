package org.example;

import sun.security.krb5.internal.TGSRep;

import java.util.*;

public class s297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int num = 1;
        while (!deque.isEmpty()){
            int newNum = 0;
            while (num-->0){
                TreeNode treeNode = deque.pop();
                if (treeNode!=null){
                    sb.append(treeNode.val);
                    if (treeNode.left!=null){
                        newNum++;
                    }
                    if (treeNode.right != null) {
                        newNum++;
                    }
                    deque.addLast(treeNode.left);
                    deque.addLast(treeNode.right);
                }else{
                    sb.append("None");
                    deque.addLast(null);
                    deque.addLast(null);
                }
            }
            num = newNum;
        }
        return String.join(sb, ",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }
    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
}
