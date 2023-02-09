package org.example;

import java.util.LinkedList;

public class S148 {
    public ListNode sortList(ListNode head) {
//        return sortList(head, null);
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0, head);
        quickSort(pre, null);
        return pre.next;
    }
    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return null;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    void quickSort(ListNode head, ListNode tail){
        if (head == null || head.next == tail || head.next.next == tail){
            return;
        }
        ListNode slow = head, fast = head;
        while (fast!=tail){
            fast = fast.next;
            slow = slow.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode root = slow;
        ListNode  cur = new ListNode(0), r = head, l = cur;
        while (r.next != tail){
            if (r.next.val >= root.val && r.next != root){
                r = r.next;
            }else if (r.next.val < root.val){
                l.next = r.next;
                l = l.next;
                r.next = r.next.next;
            }else {
                r.next = r.next.next;
            }
        }
        l.next = root;
        root.next = head.next;
        head.next = cur.next;
        quickSort(head, root);
        quickSort(root, tail);
    }


    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        S148 solution = new S148();
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode pre = new ListNode(0), cur = pre;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        solution.sortList(pre.next);

    }



}
