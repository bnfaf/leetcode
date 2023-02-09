package org.example;

public class S82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = root;
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next!=null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        S82 solution = new S82();
        ListNode root = new ListNode(-1), cur = root;
        int[] ans= {1, 1};
        for (int i = 0; i < ans.length; i++) {
            cur.next = new ListNode(ans[i]);
            cur = cur.next;
        }
        solution.deleteDuplicates(root.next);
    }
}
