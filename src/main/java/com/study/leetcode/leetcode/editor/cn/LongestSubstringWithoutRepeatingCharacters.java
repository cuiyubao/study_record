package com.study.leetcode.leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4821 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 滑动窗口方法
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            // 记录结果
            int len = 0;
            int left = 0, right = 0;
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            while (right < chars.length) {
                char rChar = chars[right];
                right++;
                // 进行窗口内数据的一系列更新
                map.put(rChar, map.getOrDefault(rChar, 0) + 1);
                // 判断左侧窗口是否要收缩
                while (map.getOrDefault(rChar,0) > 1) {
                    char lChar = chars[left];
                    // 进行窗口内数据的一系列更新
                    map.put(lChar, map.get(lChar) - 1);
                    left++;
                }
                // 在这里更新答案
                len = Math.max(len, right - left);
            }
            return len;
        }


        public int lengthOfLongestSubstring2(String s) {
            int n = s.length(), result = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int right = 0, left = 0; right < n; right++) {
                if (map.containsKey(s.charAt(right))) {
                    left = Math.max(map.get(s.charAt(right)), left);
                }
                result = Math.max(result, right - left + 1);
                map.put(s.charAt(right), right);
            }
            return result;
        }


        public int lengthOfLongestSubstring1(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int result = 0, i = 0, j = 0;
            while (i < n && j < n) {
                //charAt：返回指定位置处的字符
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    j++;
                    result = Math.max(result, j - i);
                } else {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


