package com.lear.swardToOffer.offer50;

import java.util.HashMap;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入：s = "abaccdeff"
        //输出：'b'
        String eg1 = "abaccdeff";
        char ret1 = solution.firstUniqChar(eg1);
        System.out.println(ret1);
    }
}

class Solution {
    public char firstUniqChar(String s) {
        char result = ' ';
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt.put(c, cnt.getOrDefault(c, 0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnt.get(c)==1) {
                result = c;
                break;
            }
        }
        return result;
    }
}