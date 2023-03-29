package com.lear.swardToOffer.offer35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 天狗
 * @date 2023/03/28
 */
public class Main {

    public static void main(String[] args) {

    }

}

class Solution {

    Map<Node, Node> cacheNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head==null) {
            return null;
        }
        if (!cacheNode.containsKey(head)) {
            Node n = new Node(head.val);
            cacheNode.put(head, n);
            n.next = copyRandomList(head.next);
            n.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}