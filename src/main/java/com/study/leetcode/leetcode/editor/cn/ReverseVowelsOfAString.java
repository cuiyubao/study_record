package com.study.leetcode.leetcode.editor.cn;
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 229 👎 0


import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
public Set<Character> list = new HashSet<Character>() {
    {
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }
};
        public String reverseVowels(String s) {
            char[] array = s.toCharArray();
            int i = 0, j = array.length - 1;
            char[] result = new char[array.length];
            while (i <= j) {
                char charI = array[i];
                char charJ = array[j];
                if (!list.contains(charI)){
                    result[i]=charI;
                    i++;
                }
                if (!list.contains(charJ)){
                    result[j]=charJ;
                    j--;
                }
                if (list.contains(charI)&&list.contains(charJ)){
                   result[j]=charI;
                   result[i]=charJ;
                   i++;
                   j--;
                }
            }
            return new String(result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


