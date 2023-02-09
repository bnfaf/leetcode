package org.example;

public class s92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int now = 0;
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode p1 = root, p2;
        while(p1.next != null && now + 1 < left){
            p1 = p1.next;
            now += 1;
        }
        if (now < left - 1) {
            return head;
        }
        p2 = p1.next;
        now += 1;
        while (p2 != null && now != right) {
            p2 = p2.next;
            now += 1;
        }
        while (p1.next != p2) {
            ListNode temp = p1.next;
            p1.next = temp.next;
            temp.next = p2.next;
            p2.next = temp;
        }
        return root.next;
    }

    public static void main(String[] args) {
        s92 solution = new s92();
        int[] nums = {3, 5};
        ListNode root = new ListNode(-1), curNode;
        curNode = root;
        for (int num : nums) {
            ListNode temp = new ListNode(num);
            curNode.next = temp;
            curNode = curNode.next;
        }
        ListNode res = solution.reverseBetween(root.next, 1, 2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
