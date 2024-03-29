package com.lear.swardToOffer.offer28;

import com.lear.swardToOffer.model.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *      1
 *     / \
 *    2    2
 *   / \  / \
 * 3   4 4   3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *       1
 *      / \
 *    2    2
 *      \    \
 *      3      3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：root = [1,2,2,3,4,4,3]
        //输出：true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(root.printByLevelOrder());
        System.out.println(solution.isSymmetric(root));
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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null && right==null) {
            return true;
        }
        if (left==null || right==null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}