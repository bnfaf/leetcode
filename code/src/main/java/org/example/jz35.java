package org.example;

import java.util.HashMap;
import java.util.Map;

public class jz35 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur!=null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur!=null){
            RandomListNode node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
}
