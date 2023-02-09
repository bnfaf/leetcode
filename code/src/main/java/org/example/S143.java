package org.example;

import java.util.*;

public class S143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head), l1 = head, l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }
    public ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2){
        ListNode l1_next, l2_next;
        while (l1 != null && l2 != null) {
            l1_next = l1.next;
            l2_next = l2.next;
            l1.next = l2;
            l1 = l1_next;
            l2.next = l1;
            l2 = l2_next;
        }
    }
}
