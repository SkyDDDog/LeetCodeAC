package com.lear.swardToOffer.offer40;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：arr = [3,2,1], k = 2
        //输出：[1,2] 或者 [2,1]
        int[] eg1 = new int[]{3,2,1};
        int[] ret1 = solution.getLeastNumbers(eg1, 2);
        System.out.println(Arrays.toString(Arrays.stream(ret1).toArray()));

    }

}

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, vec, 0, k);
        return vec;
    }
}