package org.example;

import java.awt.image.ImagingOpException;
import java.util.*;

public class s1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int pre = 0;
        for(ListNode node = dummy; node != null ; node = node.next){
            pre += node.val;
            map.put(pre, node);
        }
        pre = 0;
        for (ListNode node = dummy; node != null; node = node.next){
            pre += node.val;
            node.next = map.get(pre).next;
        }
        return dummy.next;
    }
}
