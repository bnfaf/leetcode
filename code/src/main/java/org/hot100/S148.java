package org.hot100;

import java.util.List;

public class S148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode root){
        if (root == null || root.next == null){
            return root;
        }
        ListNode mid = searchMid(root);
        ListNode next = mid.next;
        mid.next = null;
        return merge(mergeSort(root), mergeSort(next));
    }

    public ListNode merge(ListNode root1, ListNode root2){
        if (root1 == null && root2 == null){
            return null;
        }
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (root1 != null && root2 != null){
            if (root1.val < root2.val){
                cur.next = root1;
                root1 = root1.next;
            }else{
                cur.next = root2;
                root2 = root2.next;
            }
            cur = cur.next;
        }
        if (root1!=null){
            cur.next = root1;
        }
        if (root2 != null){
            cur.next = root2;
        }
        return dummy.next;
    }

    public ListNode searchMid(ListNode head){
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(), cur = dummy;
        int[] nums = {4, 2, 1, 3};
        for(int num: nums){
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        ListNode listNode = new S148().sortList(dummy.next);
        cur = listNode;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
