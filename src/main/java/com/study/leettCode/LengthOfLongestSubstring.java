package com.study.leettCode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * User: cuiyubao
 * Date: 2019/4/25
 * Time: 下午 07:04
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args){
        LengthOfLongestSubstring lengthOfLongestSubstring=new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring1("abcdaedcefg");
    }
    /**
     * 自己写的
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring0(String s) {
        String chun = "";
        int chu = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (chun.indexOf(String.valueOf(c[i])) < 0) {
                chun = chun + c[i];
                for (int j = i; j < c.length; j++) {
                    if (j < c.length - 1) {
                        if (chun.indexOf(String.valueOf(c[j + 1])) < 0) {
                            chun = chun + c[j + 1];
                        } else {
                            if (chun.length() > chu) {
                                chu = chun.length();
                            }
                            chun = "";
                            break;
                        }
                    } else {
                        if (chun.length() > chu) {
                            chu = chun.length();
                        }
                        chun = "";
                        break;
                    }
                }
            }
        }
        return chu;
    }

    /**
     * 答案1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s){
        int[] map = new int[256]; // map from character's ASCII to its last occured index

        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }

        return ans;

    }



}
