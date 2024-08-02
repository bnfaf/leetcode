package org.hot100;

public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, next;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
