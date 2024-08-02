package org.example;

public class S725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if (head == null){
            return res;
        }
        ListNode cur = head;
        int count = 0;
        while (cur!=null){
            cur = cur.next;
            count++;
        }
        int p = count / k, demain = count - p * k;
        cur = head;
        for(int i = 0; i < k; i++){
            int c = demain > 0 ? p+1 : p;
            demain-= 1;
            ListNode step = stepK(cur, c);
            ListNode next;
            if (step == null){
                next = null;
            }else{
                next = step.next;
                step.next = null;
            }
            res[i] = cur;
            cur = next;
        }
        return res;
    }
    public ListNode stepK(ListNode node, int k){

        if (node == null){
            return null;
        }
        ListNode dummy = new ListNode(-1, node), cur = dummy;
        while (k-->0 && cur!=null) {
            cur = cur.next;
        }
        return cur;
    }
}
