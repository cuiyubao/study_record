package com.study.leetcode.leetcode.editor.cn;
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 419 👎 0


public class ValidPalindromeIi {

    public static void main(String[] args) {
        Solution solution=new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("deeee"));
    }
 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean validPalindrome(String s) {
            char[] array = s.toCharArray();
            int j=array.length-1;
            for (int i = 0; i < array.length; i++,j--) {
                if (array[i]!=array[j]){
                    return change(array,i,j-1)||change(array,i+1,j);
                }
            }
            return true;
        }

        public boolean change(char[] array,int i,int j){
            while (i<j){
                if (array[i]!=array[j]){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}


