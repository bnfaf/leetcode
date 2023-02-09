package org.example;

public class S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy, second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        S19 solution = new S19();
        int[] nums = {1, 2};
        ListNode root = new ListNode(-1), cur = root;
        for (int i = 0; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            cur.next = tmp;
            cur = cur.next;
        }
        solution.removeNthFromEnd(root.next, 2);
    }
}
