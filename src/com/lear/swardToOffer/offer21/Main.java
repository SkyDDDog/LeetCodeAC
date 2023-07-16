package com.lear.swardToOffer.offer21;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Main {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        Solution2 solution = new Solution2();
        Solution3 solution = new Solution3();
        // eg1
        //输入：nums = [1,2,3,4]
        //输出：[1,3,2,4]
        //注：[3,1,2,4] 也是正确的答案之一。
        int[] eg1 = new int[]{1, 2, 3, 4};
//        int[] ret1 = solution.exchange(eg1);
        int[] ret1 = solution.exchange(eg1);
        System.out.println(Arrays.toString(Arrays.stream(ret1).toArray()));
        // eg2
        //[11,9,3,7,16,4,2,0]
        //[11,9,3,7,16,4,2,0]
        int[] eg2 = new int[]{11,9,3,7,16,4,2,0};
        int[] ret2 = solution.exchange(eg2);
        System.out.println(Arrays.toString(Arrays.stream(ret2).toArray()));

    }
}

// 解1: 两次遍历
class Solution {
    public int[] exchange(int[] nums) {
        int[] ret = new int[nums.length];
        int cnt = 0;
        for (int num : nums) {
            // 奇数
            if ((num & 1)==1) {
                ret[cnt++] = num;
            }
        }

        for (int num : nums) {
            // 偶数
            if ((num & 1)==0) {
                ret[cnt++] = num;
            }
        }
        return ret;
    }
}

// 解2: 双指针
class Solution2 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] ret = new int[nums.length];
        for (int num : nums) {
            // 奇数
            if ((num & 1)==1) {
                ret[left++] = num;
            } else {
                ret[right--] = num;
            }
        }
        return ret;
    }
}

// 解3: 原地交换
class Solution3 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}