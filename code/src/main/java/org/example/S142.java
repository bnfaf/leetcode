package org.example;

import java.net.InetSocketAddress;

/**
 * @author Administrator
 */
public class S142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next == null){
                return null;
            }
            fast = fast.next.next;
            if (fast == slow){
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
