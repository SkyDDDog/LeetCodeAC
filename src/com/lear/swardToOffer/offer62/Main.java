package com.lear.swardToOffer.offer62;


import com.lear.swardToOffer.model.ListNode;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入: n = 5, m = 3
        //输出: 3
        int ret1 = solution.lastRemaining(5, 3);
        System.out.println(ret1);
        // eg2
        //输入: n = 10, m = 17
        //输出: 2
        int ret2 = solution.lastRemaining(10, 17);
        System.out.println(ret2);
        // eg3
        //输入: n = 5, m = 1
        //输出: 4
        int ret3 = solution.lastRemaining(5, 1);
        System.out.println(ret3);
        // eg4
        //输入: n = 5, m = 2
        //输出: 2
        int ret4 = solution.lastRemaining(5, 2);
        System.out.println(ret4);
        // eg5 超时
        //输入: n = 70866, m = 116922
        //输出: ?
        int ret5 = solution.lastRemaining(70866, 116922);
        System.out.println(ret5);
    }

}


/**
 * 单循环链表暴力遍历
 * 超时
 */
class Solution {

    private ListNode cur, pre;
    private int ret;
    public int lastRemaining(int n, int m) {
        this.initCircle(n);
//        deleteNode(node, m);
        deleteNode(m);
        return ret;
    }

    public void deleteNode(int m) {
        if (cur == pre) {
            ret = cur.val;
            return;
        }
        if (m > 1) {
            for (int i = 0; i < m-1; i++) {
                pre = cur;
                cur = cur.next;
            }
        }
//        System.out.println("delete: " + cur.val);
        pre.next = cur.next;
        cur = pre.next;
        // 循环递归
        deleteNode(m);
    }

    private void initCircle(int n) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        this.cur = head;
        this.pre = cur;
    }
}

/**
 * 我们将上述问题建模为函数 f(n, m)，该函数的返回值为最终留下的元素的序号。
 *
 * 首先，长度为 n 的序列会先删除第 m % n 个元素，然后剩下一个长度为 n - 1 的序列。那么，我们可以递归地求解 f(n - 1, m)，就可以知道对于剩下的 n - 1 个元素，最终会留下第几个元素，我们设答案为 x = f(n - 1, m)。
 *
 * 由于我们删除了第 m % n 个元素，将序列的长度变为 n - 1。当我们知道了 f(n - 1, m) 对应的答案 x 之后，我们也就可以知道，长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。因此有 f(n, m) = (m % n + x) % n = (m + x) % n。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solutions/176636/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-by-lee/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}