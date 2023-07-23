package com.lear.swardToOffer.offer25;

import com.lear.swardToOffer.model.ListNode;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode ret1 = solution.mergeTwoLists(list1, list2);
        System.out.println(ret1.printList());
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (l1!=null || l2!=null) {
            if (l1==null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
                continue;
            }
            if (l2==null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                continue;
            }
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return head.next;
    }
}