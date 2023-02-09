package org.example;

public class s203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1), pre = dummy, cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
