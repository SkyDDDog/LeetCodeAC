package com.lear.swardToOffer.model;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayDeque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    /**
     * 层次遍历
     * @return 层次遍历结果字符串
     */
    public String printByLevelOrder() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("[");

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if (cur.left!=null) {
                queue.addLast(cur.left);
            }
            if (cur.right!=null) {
                queue.addLast(cur.right);
            }
            resultBuilder.append(cur.val).append(",");
        }
        resultBuilder.deleteCharAt(resultBuilder.length()-1);
        resultBuilder.append("]");
        return resultBuilder.toString();
    }

    public String printByMidOrder() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("[");
        String result = midOrder(this);
        resultBuilder.append(result);
        resultBuilder.deleteCharAt(resultBuilder.length()-1);
        resultBuilder.append("]");
        return resultBuilder.toString();
    }

    public String midOrder(TreeNode cur) {
        StringBuilder resultBuilder = new StringBuilder();
        if (cur.left!=null) {
            String left = midOrder(cur.left);
            resultBuilder.append(left);
        }
        resultBuilder.append(cur.val).append(",");
        if (cur.right!=null) {
            String right = midOrder(cur.right);
            if (!"".equals(right)) {
                resultBuilder.append(right);
            }
        }
        return resultBuilder.toString();
    }
}
