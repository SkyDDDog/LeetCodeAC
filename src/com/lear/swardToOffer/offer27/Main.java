package com.lear.swardToOffer.offer27;

import com.lear.swardToOffer.model.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *          4
 *      /       \
 *     2         7
 *    / \       / \
 *   1   3     6   9
 * 镜像输出：
 *
 *           4
 *      /        \
 *     7          2
 *    / \        / \
 *   9   6      3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：root = [4,2,7,1,3,6,9]
        //输出：[4,7,2,9,6,3,1]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(root.printByLevelOrder());
        TreeNode ret1 = solution.mirrorTree(root);
        System.out.println(ret1.printByLevelOrder());
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
    // 递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode mirrorLeft = mirrorTree(root.left);
        TreeNode mirrorRight = mirrorTree(root.right);
        root.right = mirrorLeft;
        root.left = mirrorRight;
        return root;
    }
}
