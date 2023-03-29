package com.lear.swardToOffer.offer07;

import com.lear.swardToOffer.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
    
}


class Solution {

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart>preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inStart;
        while (inorder[rootIndex]!=rootVal) {
            rootIndex++;
        }
        int leftSize = rootIndex - inStart;
        root.left = buildTree(preorder, inorder, preStart+1, preStart+leftSize, inStart, rootIndex-1);
        root.right = buildTree(preorder, inorder, preStart+leftSize+1, preEnd, rootIndex+1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (root == null) {
            return list;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int num = deque.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < num; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                subList.add(node.val);
            }
            list.add(subList);
        }
        return list;
    }

}
