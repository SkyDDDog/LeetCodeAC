package com.lear.swardToOffer.offer17;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Main {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        Solution2 solution = new Solution2();
        // eg.1
        //输入: n = 1
        //输出: [1,2,3,4,5,6,7,8,9]
//        int[] eg1 = solution.printNumbers(1);
//        System.out.println(Arrays.toString(Arrays.stream(eg1).toArray()));
        // eg.1
        //输入: n = 2
        //输出: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99]
        int[] eg2 = solution.printNumbers(2);
        System.out.println(Arrays.toString(Arrays.stream(eg2).toArray()));
    }

}

/**
 * 暴力遍历
 */
class Solution {
    public int[] printNumbers(int n) {
        int[] ret = new int[getMaxNumber(n)];
        for (int i = 0; i < getMaxNumber(n); i++) {
            ret[i] = i+1;
        }
        return ret;
    }

    private int getMaxNumber(int n) {
        return (int) (Math.pow(10, n)-1);
    }

}

/**
 * 排列组合
 */
class Solution2 {

    int cnt = 0;
    int[] ret;
    char[] num;
    char[] all = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        ret = new int[this.getMaxNumber(n)];
        num = new char[n];
        dfs(0, n);
        return ret;
    }
    /**
     * 递归全排列
     * @param x 当前位数
     * @param n 共几位
     */
    private void dfs(int x, int n) {
        if (x == n) {
            int curNum = Integer.parseInt(String.valueOf(num));
            if (curNum!=0) {
                ret[cnt++] = curNum;
            }
            return;
        }
        for (char c : all) {
            num[x] = c;
            this.dfs(x+1, n);
        }
    }
    private int getMaxNumber(int n) {
        return (int) (Math.pow(10, n)-1);
    }
}