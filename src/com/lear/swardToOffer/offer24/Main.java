package com.lear.swardToOffer.offer24;

import com.lear.swardToOffer.model.ListNode;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre, cur;
        pre = head;
        for (int i = 2; i <= 5; i++) {
            cur = new ListNode(i);
            pre.next = cur;
            pre = cur;
        }
        pre.next = null;

        Solution solution = new Solution();
        solution.testPrintList(head);
        ListNode rev = solution.reverseList(head);
        solution.testPrintList(rev);

    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre,cur;
        pre = null;
        cur = head;

        while (cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public void testPrintList(ListNode head) {
        for (ListNode i = head; i!=null ; i = i.next) {
            System.out.printf("%d->", i.val);
        }
        System.out.println("NULL");
    }
}