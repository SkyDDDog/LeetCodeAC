package com.lear.swardToOffer.offer68;

import com.lear.swardToOffer.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        //输出: 6
        //解释: 节点 2 和节点 8 的最近公共祖先是 6。
        TreeNode eg1 = new TreeNode(6);
        TreeNode p1 = new TreeNode(2);
        eg1.left = p1;
        TreeNode q1 = new TreeNode(8);
        eg1.right = q1;
        eg1.left.left = new TreeNode(0);
        TreeNode q2 = new TreeNode(4);
        eg1.left.right = q2;
        eg1.right.left = new TreeNode(7);
        eg1.right.right = new TreeNode(9);
        eg1.left.right.left = new TreeNode(3);
        eg1.left.right.right = new TreeNode(5);
        TreeNode ret1 = solution.lowestCommonAncestor(eg1, p1, q1);
        TreeNode ret2 = solution.lowestCommonAncestor(eg1, p1, q2);
        System.out.println(ret1);
        System.out.println(ret2);
    }

}

/**
 * 遍历二叉搜索树
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = this.getTreePath(root, p);
        List<TreeNode> qPath = this.getTreePath(root, q);
        TreeNode ret = root;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                ret = pPath.get(i);
            } else {
                break;
            }
        }
        return ret;
    }

    private List<TreeNode> getTreePath(TreeNode root, TreeNode target) {
        ArrayList<TreeNode> path = new ArrayList<>();
        while (root.val!=target.val) {
            path.add(root);
            if (root.val < target.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        path.add(root);
        return path;
    }
}