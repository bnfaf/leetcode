package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class s23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQue = new PriorityQueue<ListNode>((a, b)->{
            return a.val - b.val;
        });
        ListNode head = new ListNode(-1), cur = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                priorityQue.offer(lists[i]);
            }
        }
        while (!priorityQue.isEmpty()){
            cur.next = priorityQue.poll();
            cur = cur.next;
            if (cur.next!=null){
                priorityQue.offer(cur.next);
            }
            cur.next = null;
        }
        return head.next;
    }
    public ListNode merge(ListNode[] lists, int l, int r){
        if (l == r){
            return lists[l];
        }
        if (l>r){
            return null;
        }
        int mid = (l+r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));
    }
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if (a == null || b == null){
            return a != null ? a:b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, btrNode = b ;
        while (aPtr != null && btrNode != null){
            if (aPtr.val < btrNode.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else{
                tail.next = btrNode;
                btrNode = btrNode.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : btrNode);
        return head.next;
    }
}
