package com.lear.swardToOffer.offer52;

import com.lear.swardToOffer.model.ListNode;

import java.util.HashMap;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
        //输出：Reference of the node with value = 8
        //输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
        ListNode headA = new ListNode(4);
        ListNode inter = new ListNode(8);
        inter.next = new ListNode(4);
        inter.next.next = new ListNode(5);
        headA.next = new ListNode(1);
        headA.next.next = inter;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = inter;
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);


    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> listA = new HashMap<>();
        for (ListNode cur = headA; cur!=null ; cur = cur.next) {
            listA.put(cur, true);
        }
        for (ListNode cur = headB; cur!=null ; cur = cur.next) {
            if (listA.getOrDefault(cur, false)) {
                return cur;
            }
        }
        return null;
    }
}