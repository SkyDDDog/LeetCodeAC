package com.lear.swardToOffer.offer55Ⅱ;

import com.lear.swardToOffer.model.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //给定二叉树 [3,9,20,null,null,15,7]
        //
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        //返回 true
        TreeNode eg1 = new TreeNode(3);
        eg1.left = new TreeNode(9);
        eg1.right = new TreeNode(20);
        eg1.right.left = new TreeNode(15);
        eg1.right.right = new TreeNode(7);
        boolean ret1 = solution.isBalanced(eg1);
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
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        return (Math.abs(this.height(root.right)-this.height(root.left)) <= 1)
                && this.isBalanced(root.left) && this.isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return Math.max(this.height(root.left), this.height(root.right)) + 1;
    }
}
