package org.example;

public class s86 {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1), graterNode = new ListNode(-1);
        ListNode curLessNode = less, curGaterNode = graterNode;
        while (head!=null){
            ListNode next = head.next;
            head.next = null;
            if (head.val < x){
                curLessNode.next = head;
                curLessNode = curLessNode.next;
            }else{
                curGaterNode.next = head;
                curGaterNode = curGaterNode.next;
            }
            head = next;
        }
        if (less.next == null){
            return graterNode.next;
        }
        curLessNode.next = graterNode.next;
        return less.next;

    }
}
