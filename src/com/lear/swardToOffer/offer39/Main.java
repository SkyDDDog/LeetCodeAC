package com.lear.swardToOffer.offer39;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
        //输出: 2
        int[] eg1 = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int ret1 = solution.majorityElement(eg1);
        System.out.println(ret1);
        // eg2
        //[3,3,4]
        //3
        int[] eg2 = new int[]{3,3,4};
        int ret2 = solution.majorityElement(eg2);
        System.out.println(ret2);
    }

}

class Solution {
    public int majorityElement(int[] nums) {
        AtomicInteger result = new AtomicInteger();
        int total = nums.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }
        cnt.forEach((k,v) -> {
            if (v > total/2) {
                result.set(k);
            }
        });
        return result.get();
    }
}