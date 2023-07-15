package com.lear.swardToOffer.model;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public String printList() {
        StringBuilder ret = new StringBuilder();
        ret.append('[');
        for (ListNode cur = this; cur != null ; cur = cur.next) {
            ret.append(cur.val).append(',');
        }
        ret.deleteCharAt(ret.length()-1).append(']');
        return ret.toString();
    }
}