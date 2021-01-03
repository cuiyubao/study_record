package com.study.leetcode.leetcode.editor.cn;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 308 👎 0


public class ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            char[] c = s.toCharArray();
            int i = 0;
            int j = c.length - 1;
            while (i < j) {
                if (!((c[i] >= '0' && c[i] <= '9') || (c[i] >= 'a' && c[i] <= 'z'))) {
                    i++;
                    continue;
                }
                if (!((c[j] >= '0' && c[j] <= '9') || (c[j] >= 'a' && c[j] <= 'z'))) {
                    j--;
                    continue;
                }
                if (c[i] != c[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean isPalindrome1(String s) {
            s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[chars.length - 1 - i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


