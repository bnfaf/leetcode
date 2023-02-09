package org.example;

public class S2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, tmp, num1, num2;
        ListNode  pre = new ListNode(-1), curr = pre;
        // 有可以加的或者有进位
        while (l1 != null || l2 != null || carry == 1){
            num1 = l1!=null?l1.val:0;
            num2 = l2 != null? l2.val:0;
            //记录和 以及进位
            tmp = num1 + num2 + carry;
            carry = tmp >= 10?1:0;
            // l1 不为空，就使用 cur,
            if (l1!=null){
                l1.val = tmp>=10?tmp-10:tmp;
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
                l2 = l2 != null?l2.next: null;

            }else  if (l2 != null){
                //l2不为空，就使用l2
                l2.val = tmp>=10?tmp-10:tmp;
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }else if (l1 == null  && l2 == null && tmp == 1){
                // l1,l2均为空，还有进位，必须新建
                ListNode temp = new ListNode(tmp);
                curr.next = temp;
                curr = curr.next;
                carry = 0;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 9};
        int[] nums2 = {5,6,4,9};
        ListNode l1 = new ListNode(-1), l2 = new ListNode(-1), cur = l1;
        for (int i = 0; i < nums1.length; i++) {
            cur.next = new ListNode(nums1[i]);
            cur = cur.next;
        }
        cur = l2;
        for (int i = 0; i < nums2.length; i++) {
            cur.next = new ListNode(nums2[i]);
            cur = cur.next;
        }
        S2 solution = new S2();
        solution.addTwoNumbers(l1.next, l2.next);
    }
}
