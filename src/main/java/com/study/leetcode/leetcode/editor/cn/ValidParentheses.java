package com.study.leetcode.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2982 👎 0


import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        Solution solution=new ValidParentheses().new Solution();

    }
 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length()==0){
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar=='('||aChar=='{'||aChar=='['){
                 stack.push(aChar);
            }else if (aChar==')'){
                if (!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else {
                    return false;
                }
            }else if (aChar=='}'){
                if (!stack.isEmpty()&&stack.peek()=='{'){
                    stack.pop();
                }else {
                    return false;
                }
            }else if (aChar==']'){
                if (!stack.isEmpty()&&stack.peek()=='['){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


