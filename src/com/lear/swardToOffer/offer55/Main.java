package com.lear.swardToOffer.offer55;

import com.lear.swardToOffer.model.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //给定二叉树 [3,9,20,null,null,15,7]，
        //
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        //返回它的最大深度 3
        TreeNode eg1 = new TreeNode(3);
        eg1.left = new TreeNode(3);
        eg1.right = new TreeNode(20);
        eg1.right.left = new TreeNode(15);
        eg1.right.right = new TreeNode(7);
        int ret1 = solution.maxDepth(eg1);
        System.out.println(ret1);


    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}