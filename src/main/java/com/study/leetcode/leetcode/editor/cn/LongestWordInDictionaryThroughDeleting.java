package com.study.leetcode.leetcode.editor.cn;
//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 267 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        solution.findLongestWord("abce", Arrays.asList("abe", "abc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            dictionary.sort((String s1, String s2) -> {
                if (s1.length() > s2.length()) {
                    return -1;
                } else if (s1.length() == s2.length()) {
                    char[] cS1 = s1.toCharArray();
                    char[] cS2 = s2.toCharArray();
                    for (int i = 0; i < s1.length(); i++) {
                        if (cS1[i] > cS2[i]) {
                            return 1;
                        } else if (cS1[i] < cS2[i]) {
                            return -1;
                        }
                    }
                } else {
                    return 1;
                }
                return 0;
            });
            for (String dic : dictionary) {
                char[] dicChars = dic.toCharArray();
                char[] sChars = s.toCharArray();
                int dicIndex = 0;
                int sIndex = 0;
                while (sIndex < sChars.length) {
                    if (sChars[sIndex] == dicChars[dicIndex]) {
                        sIndex++;
                        dicIndex++;
                    } else {
                        sIndex++;
                    }
                    if (dicIndex == dic.length()) {
                        return dic;
                    }
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


