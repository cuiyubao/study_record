package com.study.leettCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * User: cuiyubao
 * Date: 2019/4/27
 * Time: 下午 11:10
 */
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords2("a good          example"));
    }

    /**
     * 自己的
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] splitArray = s.split(" ");
        String[] re = new String[splitArray.length];
        for (int i = splitArray.length - 1; i >= 0; i--) {
            re[splitArray.length - i - 1] = splitArray[i];
        }
        String result = "";
        for (String s1 : re) {
            if (s1.length() > 0) {
                result = result + " " + s1;
            }
        }
        return result.trim();
    }

    /**
     * 别人4ms的写法
     *
     * @param s
     * @return
     */
    public static String reverseWords0(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i == -1) break;

            int j = s.lastIndexOf(' ', i);
            builder.append(s.substring(j + 1, i + 1) + " ");
            i = j - 1;
        }

        if (builder.length() > 0) builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    /**
     * 代码量减少了，但用时增加  内存占用增加
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        String[] words = s.trim().split(" ");
        List<String> list=Arrays.stream(words).filter(e->e.length()>0).collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }




}
