package com.lear.swardToOffer.offer42;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出: 6
        //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
        int[] eg1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ret1 = solution.maxSubArray(eg1);
        System.out.println(ret1);
    }

}

// 动态规划
// f(i)=max{f(i−1)+nums[i],nums[i]}
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}