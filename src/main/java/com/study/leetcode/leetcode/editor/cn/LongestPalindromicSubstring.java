package com.study.leetcode.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4721 👎 0


public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String result = "";
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                //返回值为奇数
                String s1 = search(s, i, i);
                //返回值为偶数
                String s2 = search(s, i, i + 1);
                result = result.length() > s1.length() ? result : s1;
                result = result.length() > s2.length() ? result : s2;
            }
            return result;
        }

        public String search(String s, int l, int r) {
            while (l >=0 && r < s.length()&&s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
            }
            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


