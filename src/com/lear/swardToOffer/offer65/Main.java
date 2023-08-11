package com.lear.swardToOffer.offer65;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入: a = 1, b = 1
        //输出: 2
        int ret1 = solution.add(1, 1);
        System.out.println(ret1);
    }

}


class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}