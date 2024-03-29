package com.study.leetcode.leetcode.editor.cn;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1629 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            char[] chars = t.toCharArray();
            char[] sChars = s.toCharArray();
            for (char c : chars) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            //记录最小覆盖子串的起始索引以及长度
            int start = 0;
            int len = Integer.MAX_VALUE;
            //包含目标元素的个数
            int valid = 0;
            while (right < s.length()) {
                char sChar = sChars[right];
                // 右移窗口
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(sChar)) {
                    window.put(sChar, window.getOrDefault(sChar, 0) + 1);
                    if (window.get(sChar).equals(need.get(sChar))) {
                        valid++;
                    }
                }
                // 判断左侧窗口是否要收缩
                while (valid == need.size()) {
                    //更新最小覆盖子串
                    if (right - left < len) {
                        len = right - left;
                        start = left;
                    }
                    // leftChar 是将移出窗口的字符
                    char leftChar = sChars[left];
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(leftChar)){
                        if (Objects.equals(need.get(leftChar), window.get(leftChar))){
                            valid--;
                        }
                        window.put(leftChar,window.get(leftChar)-1);
                    }
                }
            }
            // 返回最小覆盖子串
            return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


