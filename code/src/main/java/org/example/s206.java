package org.example;

public class s206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1, null), cur = head, next;
        while (cur != null){
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;

    }
}
