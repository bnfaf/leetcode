package org.example;

public class s2407 {
    int[] max;
    public int lengthOfLIS(int[] nums, int k) {
        for (int num: nums){
            if (num == 1){
                update(root, 1, N, 1, 1, 1);
            }else{
                int startidx = Math.max(num-k, 1);
                int res = 1+query(root, 1, N, startidx, num-1);
                update(root, 1, N, num, num, res);
            }
        }
        return query(root, 1, N, 1, N);
    }
    class Node{
        Node left, right;
        int val, add;
    }
    private int N = (int)1e9;
    private Node root = new Node();
    public void update(Node node, int start, int end, int l, int r, int val){
        if (l <= start && end <= r){
            node.val = val;
            node.add = val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid){
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid){
            update(node.right, mid+1, end, l, r, val);
        }
        pushUp(node);
    }
    public int query(Node node, int start, int end, int l, int r){
        if (l <= start && end <= r){
            return node.val;
        }
        pushDown(node);
        int mid = (start + end) >> 1, ans = 0;
        if (l <= mid){
            ans = query(node.left, start, mid, l, r);
        }
        if (r>mid){
            ans = Math.max(ans, query(node.right, mid+1, end, l, r));
        }
        return ans;
    }
    private void pushUp(Node node){
        node.val = Math.max(node.left.val, node.right.val);
    }

    private void pushDown(Node node){
        if (node.left == null){
            node.left = new Node();
        }
        if (node.right == null){
            node.right = new Node();
        }
        if (node.add == 0){
            return;
        }
        node.left.val = node.add;
        node.right.val = node.add;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,4,3,4,5,8,15};
        int k = 3;
        s2407 solution = new s2407();
        System.out.println(solution.lengthOfLIS(nums, k));
    }
}
