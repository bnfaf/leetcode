package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class s23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        List<Integer> store = new ArrayList<>(lists.length);
        int num = 0;
        for (ListNode list:lists) {
            if (list!=null) {
                store.add(list.val);
            }else {
                store.add(Integer.MAX_VALUE);
                num += 1;
            }
        }
        ListNode cur = head;
        while (num < lists.length) {
            int index = store.indexOf(Collections.min(store));
            cur.next = lists[index];
            cur = cur.next;
            lists[index] = lists[index].next;
            if (lists[index] == null) {
                store.set(index, Integer.MAX_VALUE);
                num++;
            }else {
                store.set(index, lists[index].val);
            }
        }
        return head.next;
    }
}
