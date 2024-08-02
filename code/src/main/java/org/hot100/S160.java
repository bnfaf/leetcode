package org.hot100;

public class S160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int[] flag = new int[]{0, 0};
        while (p != q) {
            p = p.next;
            q = q.next;
            if (p == null && flag[0] == 0) {
                p = headB;
                flag[0] = 1;
            }
            if (q == null && flag[1] == 0) {
                q = headA;
                flag[1] = 1;
            }
        }
        return p;
    }
}
