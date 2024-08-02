package org.example;

public class s328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1), curOdd = odd;
        ListNode even = new ListNode(-1), curEven = even;
        while (head!=null){
            ListNode next = head.next;
            curOdd.next = head;
            curOdd = curOdd.next;
            curEven.next = next;
            curEven = curEven.next;
            if (next!=null){
                head = next.next;
            }else{
                head = null;
            }
        }

        curOdd.next = even.next;
        return odd.next;
    }
}
