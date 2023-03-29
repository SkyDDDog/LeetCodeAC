package com.lear.swardToOffer.offer06;

import com.lear.swardToOffer.model.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author 天狗
 * @date 2023/03/27
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        Solution solution = new Solution();
        int[] result = solution.reversePrint(head);
        System.out.println(Arrays.toString(result));


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

    private Deque<Integer> data = new ArrayDeque<>();
    private int[] result;

    public int[] reversePrint(ListNode head) {
        while (head!=null) {
            data.push(head.val);
            head = head.next;
        }
        int length = data.size();
        result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = data.getFirst();
//            System.out.println(data.getFirst());
            data.pop();
        }
        return result;
    }
}