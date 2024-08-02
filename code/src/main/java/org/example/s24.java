package org.example;

import java.net.PasswordAuthentication;

public class s24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(), end = dummy;
        int k = 2;
        ListNode cur = head;
        while (cur != null) {
            int index = 1;
            ListNode temp = cur;
            while (index < k && temp.next != null) {
                temp = temp.next;
                index += 1;
            }
            if (index < k) {
                end.next = cur;
                break;
            }
            ListNode next = temp.next, pre = null;
            temp = cur;
            while (temp != next) {
                ListNode next1 = temp.next;
                temp.next = pre;
                pre = temp;
                temp = next1;
            }
            end.next = pre;
            while (end.next!=null){
                end = end.next;
            }
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode dummy = new ListNode(-1), cur = dummy;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        s24 solution = new s24();
        System.out.println(solution.swapPairs(dummy.next));
    }
}