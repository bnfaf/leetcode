package org.example;

public class s21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode now = preHead;
        while (list1 != null & list2 != null){
            if (list1.val <= list2.val) {
                now.next = list1;
                list1 = list1.next;
            }else{
                now.next = list2;
                list2 = list2.next;
            }
            now = now.next;
        }
        if (list1 != null){
            now.next = list1;
        }
        if (list2 != null){
            now.next = list2;
        }
        return preHead.next;

    }
}
