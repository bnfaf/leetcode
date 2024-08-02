package org.example;

public class s83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if (cur == null){
            return null;
        }
        while (cur.next!=null){
            if (cur.next.val != cur.val){
                cur = cur.next;
            }else{
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}
