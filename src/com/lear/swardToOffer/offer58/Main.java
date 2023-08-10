package com.lear.swardToOffer.offer58;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // eg1
        //输入: "the sky is blue"
        //输出: "blue is sky the"
        String ret1 = solution.reverseWords("the sky is blue");
        System.out.println(ret1);
        // eg2
        //输入: "  hello world!  "
        //输出: "world! hello"
        //解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        String ret2 = solution.reverseWords("  hello world!  ");
        System.out.println(ret2);
        // eg3
        //输入: "a good   example"
        //输出: "example good a"
        //解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
        String ret3 = solution.reverseWords("a good   example");
        System.out.println(ret3);
    }
}

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" +");
        List<String> list = Arrays.asList(words);
        Collections.reverse(list);
        StringBuilder builder = new StringBuilder();
        for (String string : list) {
            if ("".equals(string)) {
                continue;
            }
            builder.append(string).append(" ");
        }
        if (builder.length()>1) {
            builder.deleteCharAt(builder.length()-1);
        }
        return builder.toString();
    }
}
