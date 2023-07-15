package com.lear.swardToOffer.offer15;

/**
 * <p>
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * <p/>
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg.1
        //输入：n = 11 (控制台输入 00000000000000000000000000001011)
        //输出：3
        //解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
        int eg1 = solution.hammingWeight(11);
        System.out.println("eg1: "+ eg1);
        // eg.2
        //输入：n = 128 (控制台输入 00000000000000000000000010000000)
        //输出：1
        //解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
        int eg2 = solution.hammingWeight(128);
        System.out.println("eg2: "+ eg2);
        // eg.3
        //输入：n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
        //输出：31
        //解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
        int eg3 = solution.hammingWeight(-3);
        System.out.println("eg3: "+ eg3);
    }
}

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}