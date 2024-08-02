package org.example;

/**
 * 线段树 动态开点
 */
public class SegmentTreeDynamic {
    class Node{
        Node left, right;
        int val, add;
    }
    private int N = (int)1e9;
    private Node root = new Node();

    /**
     * 在[start, end]中更新区间[l,r]的值， 将区间[l, r]+val
     */
    public void update(Node node, int start, int end, int l, int r, int val){
        if (l <= start && end <= r){
            node.val += (end - start + 1) * val;
            node.add += val;
            return;
        }
        int mid = (start + end) >>1;
        pushDown(node, mid-start+1, end-mid);
        if (l<=mid){
            update(node.left, start, mid, l, r, val);
        }
        if (r>mid){
            update(node.right, mid+1, end, l, r, val);
        }
        pushUp(node);
    }
    /**
     * 在[start, end]中查询区间[l,r]的值
     */
    public int query(Node node, int start, int end ,int l, int r){
        if (l <= start && end <= r ){
            return node.val;
        }
        int mid = (start + end) >> 1, ans = 0;
        pushDown(node.left, mid-start+1, end-mid);
        if (l<=mid){
            ans += query(node.left,start, mid, l, r );
        }
        if (r>=mid){
            ans += query(node.right, mid+1, end, l, r);
        }
        return ans;
    }
    // 更新值
    private void pushUp(Node node){
        node.val = node.left.val + node.right.val;
    }

    /**
     *leftNum ,rightNum 表示左右孩子区间的叶子节点数量
     * 如果是加减更新操作，需要用懒惰标记的值*叶子节点的数量
     */
    private  void pushDown(Node node, int leftNum, int rightNum){
        //  动态开点
        if (node.left == null){
            node.left = new Node();
        }
        if (node.right == null){
            node.right = new Node();
        }
        if (node.add == 0){
            return;
        }
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

}
