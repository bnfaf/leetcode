package org.example;

import java.util.List;

public class S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast=dummy, slow =dummy;
        while (n-->0&& fast!=null){
            fast = fast.next;
        }
        if (fast==null){
            return dummy.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        S19 solution = new S19();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode root = new ListNode(-1), cur = root;
        for (int i = 0; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            cur.next = tmp;
            cur = cur.next;
        }
        solution.removeNthFromEnd(root.next, 2);
        cur = root.next;
        while (cur!= null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
