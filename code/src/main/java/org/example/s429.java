package org.example;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class s429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            while (size-->0){
                Node node = deque.pollFirst();
                temp.add(node.val);
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null){
                        deque.addLast(node.children.get(i));
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }
}
