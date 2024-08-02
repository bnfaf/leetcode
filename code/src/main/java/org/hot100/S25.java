package org.hot100;



public class S25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), dum = dummy, cur = head;
        while (cur!=null){
            int num = k;
            ListNode curr = cur;
            while (curr!=null&& num-->1){
                curr = curr.next;
            }
            if (curr == null){
                dum.next = cur;
                break;
            }else{
                ListNode cnext = curr.next, pre = null;
                while (cur!=cnext){
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                dum.next = pre;
                while (dum.next!=null){
                    dum = dum.next;
                }
            }
        }
        return dummy.next;
    }
}
