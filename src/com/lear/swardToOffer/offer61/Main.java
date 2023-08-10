package com.lear.swardToOffer.offer61;

import java.util.*;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入: [1,2,3,4,5]
        //输出: True
        int[] eg1 = {1, 2, 3, 4, 5};
        boolean ret1 = solution.isStraight(eg1);
        System.out.println(ret1);
        // eg2
        //输入: [0,0,1,2,5]
        //输出: True
        int[] eg2 = {0,0,1,2,5};
        boolean ret2 = solution.isStraight(eg2);
        System.out.println(ret2);

    }
}

class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            // 跳过大小王
            if(num == 0) {
                continue;
            }
            // 最大牌
            max = Math.max(max, num);
            // 最小牌
            min = Math.min(min, num);
            // 若有重复，提前返回 false
            if(repeat.contains(num)) {
                return false;
            }
            // 添加此牌至 Set
            repeat.add(num);
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }
}