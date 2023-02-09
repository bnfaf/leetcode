package org.example;

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast.next!=null && k-- > 1){
            fast = fast.next;
        }
        if (fast == null){
            return null;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
