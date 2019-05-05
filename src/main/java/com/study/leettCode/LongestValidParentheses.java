package com.study.leettCode;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * User: cuiyubao
 * Date: 2019/5/1
 * Time: 上午 02:28
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses1("(()"));
    }

    /**
     * 栈的解法，遇到左括号下标入栈，遇到右括号出栈并更新最大值
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int res = 0;//返回的长度值
        int start = 0;//每一个穿串开始时的坐标值
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i);
            if (a == '(') {
                stack.push(i);
            } else if (a == ')') {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    res = stack.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;

    }

    /**
     * 答案中用时最短的
     * 思路：两个for循环分别从两边找  要是右边大于左说明左括号多了-》结束-》继续开始，
     * 找见左边开始最大的  再从右边开始找到右边开始最大的
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        int left = 0, right = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            }
            if (right > left) {
                left = right = 0;
            }

        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            }
            if (right < left) {
                left = right = 0;
            }

        }
        return result;
    }

}
