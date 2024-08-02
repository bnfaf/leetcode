package org.example;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class s662 {
    class Node{
        TreeNode treeNode;
        int id;
        public Node(TreeNode node, int id) {
            this.treeNode = node;
            this.id = id;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(new Node(root, 1));
        while (!deque.isEmpty()){
            int size = deque.size();
            int wide = deque.peekLast().id - deque.peekFirst().id + 1;
            ans = Math.max(ans, wide);
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                if (node.treeNode.left!=null){
                    deque.addLast(new Node(node.treeNode.left, 2*node.id));
                }
                if (node.treeNode.right != null){
                    deque.addLast(new Node(node.treeNode.right, 2 * node.id+1));
                }
            }
        }
        return ans;
    }
}
