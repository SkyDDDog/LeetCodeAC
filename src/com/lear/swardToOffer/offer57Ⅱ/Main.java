package com.lear.swardToOffer.offer57Ⅱ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：target = 9
        //输出：[[2,3,4],[4,5]]
        int[][] ret1 = solution.findContinuousSequence(9);
        solution.printDoubleArray(ret1);
        // eg2
        //输入：target = 15
        //输出：[[1,2,3,4,5],[4,5,6],[7,8]]
        int[][] ret2 = solution.findContinuousSequence(15);
        solution.printDoubleArray(ret2);

    }



}


/**
 * 暴力枚举
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int i = 1; i <= limit; ++i) {
            for (int j = i;; ++j) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    public void printDoubleArray(int[][] ret) {
        StringBuilder builder = new StringBuilder("[");
        for (int[] ints : ret) {
            builder.append("[");
            for (int anInt : ints) {
                builder.append(anInt).append(",");
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append("]").append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        System.out.println(builder.toString());
    }
}