package org.example;

/**
 * @author Administrator
 */
public class s141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode one = head, two = head;
        while (two.next != null) {
            if (one != two) {
                one = one.next;
                two = two.next.next;
            }else{

                return true;
            }
        }
        return false;

    }
}
