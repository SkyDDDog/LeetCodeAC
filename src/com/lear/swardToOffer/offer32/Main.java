package com.lear.swardToOffer.offer32;

import com.lear.swardToOffer.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //给定二叉树: [3,9,20,null,null,15,7],
        //[
        //  [3],
        //  [9,20],
        //  [15,7]
        //]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
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

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        this.levelOrder(root, 0);
        return result;
    }
    private void levelOrder(TreeNode root, int level) {
        if (root!=null) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            levelOrder(root.left, level+1);
            levelOrder(root.right, level+1);
        }
    }
}
