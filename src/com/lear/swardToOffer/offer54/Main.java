package com.lear.swardToOffer.offer54;

import com.lear.swardToOffer.model.TreeNode;

import java.util.*;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
public class Main {

    public static void main(String[] args) {
//        Solution solution = new Solution();
        Solution2 solution = new Solution2();
        // eg1
        //输入: root = [3,1,4,null,2], k = 1
        //   3
        //  / \
        // 1   4
        //  \
        //   2
        //输出: 4
        TreeNode eg1 = new TreeNode(3);
        eg1.left = new TreeNode(1);
        eg1.right = new TreeNode(4);
        eg1.left.right = new TreeNode(2);
        int ret1 = solution.kthLargest(eg1, 1);
        System.out.println(ret1);

        // eg2
        //输入: root = [5,3,6,2,4,null,null,1], k = 3
        //       5
        //      / \
        //     3   6
        //    / \
        //   2   4
        //  /
        // 1
        //输出: 4
        TreeNode eg2 = new TreeNode(5);
        eg2.left = new TreeNode(3);
        eg2.right = new TreeNode(6);
        eg2.left.left = new TreeNode(2);
        eg2.left.right = new TreeNode(4);
        eg2.left.left.left = new TreeNode(1);
        int ret2 = solution.kthLargest(eg2, 3);
        System.out.println(ret2);

        // eg3
        //root = [5,3,6,2,4,null,null,1], k = 3
        //4
        TreeNode eg3 = new TreeNode(5);
        eg3.left = new TreeNode(3);
        eg3.right = new TreeNode(6);
        eg3.left.left = new TreeNode(2);
        eg3.left.right = new TreeNode(4);
        eg3.left.left.left = new TreeNode(1);
        int ret3 = solution.kthLargest(eg3, 4);
        System.out.println(ret3);

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

/**
 * 暴力解法
 * 遍历+排序
 */
class Solution {
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> valList = new ArrayList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
            valList.add(cur.val);
        }
        valList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        return valList.get(k-1);
    }
}

/**
 * 根据二叉搜索树特性
 * 二叉搜索树的中序遍历是递增
 * 中序倒序遍历是递减    右 中 左
 * 中序遍历
 */
class Solution2 {

    private int k ;
    private int result;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        dfs(root.right);
        if (k==0) {
            return;
        }
        if (--k==0) {
            result = root.val;
        }
        dfs(root.left);
    }
}