package org.example;

import java.net.PasswordAuthentication;

public class s24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, null), cur = head, end = dummy;
        ListNode first, second;
        while (cur != null && cur.next != null){
            first = cur;
            second = cur.next;
            cur = second.next;
            end.next = second;
            second.next = first;
            first.next = null;
            end = first;
        }
        end.next = cur;
        return dummy.next;
    }
}
