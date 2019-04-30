package com.study.lintCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true
 * User: cuiyubao
 * Date: 2019/5/1
 * Time: 上午 01:46
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        boolean result = false;
        Stack<String> stack = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                stack.push(String.valueOf(s.charAt(i)));
            } else if (i > 0) {
                if (stack.size()>0&&stack.peek().equals(map.get(String.valueOf(s.charAt(i))))) {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                }
            }
        }
        if (stack.size() == 0) {
            result = true;
        }
        return result;
    }

}
