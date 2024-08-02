package org.example;

public class s206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head, next = reverseList(head.next);
        cur.next.next = cur;
        cur.next = null;
        return next;
    }
}
