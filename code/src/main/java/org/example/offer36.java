package org.example;
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class offer36 {
    Node1 pre,head;

    public Node1 treeToDoublyList(Node1 root) {
        if (root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;

    }
    public void dfs(Node1 cur){
        if (cur == null){
            return;
        }
        dfs(cur.left);
        if (pre != null){
            pre.right = cur;
        }else{
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
