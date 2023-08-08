package com.lear.swardToOffer.offer57;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：nums = [2,7,11,15], target = 9
        //输出：[2,7] 或者 [7,2]
        int[] eg1 = new int[]{2,7,11,15};
        int[] ret1 = solution.twoSum(eg1, 9);
        System.out.println(Arrays.toString(ret1));
        // eg2
        //输入：nums = [10,26,30,31,47,60], target = 40
        //输出：[10,30] 或者 [30,10]
        int[] eg2 = new int[]{10,26,30,31,47,60};
        int[] ret2 = solution.twoSum(eg2, 40);
        System.out.println(Arrays.toString(ret2));

    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            int sum = nums[left]+nums[right];
            if (sum<target) {
                left++;
            } else if (sum>target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[2];
    }
}
