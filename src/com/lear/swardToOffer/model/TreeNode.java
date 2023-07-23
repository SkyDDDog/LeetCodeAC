package com.lear.swardToOffer.model;

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
}
