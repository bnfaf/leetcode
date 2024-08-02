package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class s327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i+1] = sum;
        }
        Set<Long> allNumber = new TreeSet<>();
        for (long x : preSum){
            allNumber.add(x);
            allNumber.add(x - lower);
            allNumber.add(x - upper);
        }
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumber) {
            values.put(x, idx);
            idx++;
        }

        Node root = build(0, values.size() - 1);
        int ret = 0;
        for (long x : preSum) {
            int left = values.get(x - upper), right = values.get(x - lower);
            ret += count(root, left, right);
            insert(root, values.get(x));
        }
        return ret;

    }
    class Node{
        public int lo, hi;
        public int add;
        Node leftChild, rightChild;
        public Node(int left, int right){
            this.lo = left;
            this.hi = right;
            add = 0;
            leftChild = null;
            rightChild = null;
        }
    }

    public Node build(int left, int right){
        Node node = new Node(left, right);
        int mid = (left + right) / 2;
        node.leftChild = build(left, mid);
        node.rightChild = build(mid+1, right);
        return node;
    }
    public int count(Node root, int left, int right){
        if (left > root.hi || right < root.lo){
            return 0;
        }
        if (left <= root.lo && right >= root.hi){
            return root.add;
        }
        return count(root.leftChild, left, right) + count(root.rightChild, left, right);
    }
    public void insert(Node root, int val){
        root.add++;
        if (root.lo == root.hi){
            return;
        }
        int mid = (root.lo + root.hi) / 2;
        if (val <= mid){
            insert(root.leftChild, val);
        }else{
            insert(root.rightChild, val);
        }
    }
}
