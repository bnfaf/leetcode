package org.example;

public class s0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        boolean flag = true, flag1 = true;
        while (node1.val != node2.val && node1 != null && node2 != null){
            if (node1.next == null && flag){
                flag = false;
                node1 = headB;
            }else {
                node1 = node1.next;
            }
            if (node2.next == null && flag1 ) {
                flag1 = false;
                node2 = headA;
            }else {
                node2 = node2.next;
            }

        }

        return node1.val == node2.val? node1 : null;
    }

}
