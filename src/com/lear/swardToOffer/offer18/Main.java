package com.lear.swardToOffer.offer18;

import com.lear.swardToOffer.model.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 */
public class Main {
    public static void main(String[] args) {
        // eg
        ListNode head = new ListNode(-3);
        ListNode node2 = new ListNode(5);
        head.next = node2;
        ListNode node3 = new ListNode(-99);
        node2.next = node3;
        node3.next = null;

        Solution solution = new Solution();
        ListNode listNode = solution.deleteNode(head, -3);
        String s = listNode.printList();
        System.out.println(s);

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
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        if (head.val == val) {
            return head.next;
        }
        for (ListNode cur = head.next; cur!=null ; cur = cur.next) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = cur;
        }
        return head;
    }
}