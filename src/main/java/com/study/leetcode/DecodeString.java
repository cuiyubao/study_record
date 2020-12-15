package com.study.leetcode;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * User: cuiyubao
 * Date: 2019/5/2
 * Time: 上午 12:48
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString1("2[abc]3[cd]ef"));

    }

    /**
     * 自己写的   少考虑了 3[z]2[2[y]pq4[2[jk]e1[f]]]ef
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] first = s.split("]");//第一次切割
        for (int i = 0; i < first.length; i++) {
            String SECOND = first[i];
            if (SECOND.indexOf("[") >= 0) {
                String[] second = SECOND.split("\\[");
                Integer len = Integer.valueOf(second[0]);//重复次数
                String ss = second[1];
                for (int j = 0; j < len; j++) {
                    stringBuilder.append(ss);
                }
            } else {
                stringBuilder.append(SECOND);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 执行时间1ms   第一次自己写的执行时间会这么快   不过代码量还是有点多
     * @param s
     * @return
     */
    public static String decodeString1(String s) {
        String result = "";
        Stack<String> operandStack = new Stack<>();//操作数  如 ert[]d
        Stack<String> operatorStack = new Stack<>();//运算符号  数字
        for (int i = 0; i < s.length(); i++) {
            String token = String.valueOf(s.charAt(i));
            if (isNumeric(token)) {
                if (isNumeric(String.valueOf(s.charAt(i+1)))){
                    operatorStack.push(token);
                }else {
                    operatorStack.push(token);
                    operatorStack.push(":");
                }
            } else {
                if (!token.equals("]")) {
                    operandStack.push(token);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    String unit = "";
                    String num="";
                    while (!operandStack.peek().equals("[")) {
                        unit = operandStack.pop() + unit;
                    }
                    operandStack.pop();
                    operatorStack.pop();
                    while (!operatorStack.isEmpty()&&!operatorStack.peek().equals(":")) {
                        num = operatorStack.pop() + num;
                    }
                    int len = Integer.parseInt(num);
                    for (int j = 0; j < len; j++) {
                        stringBuilder.append(unit);
                    }
                    operandStack.push(stringBuilder.toString());
                }
            }
        }
        while (!operandStack.isEmpty()) {
            result = operandStack.pop() + result;
        }
        return result;
    }

    /**
     * 判断一个字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

    /**
     * 别人的也是执行时间1ms的
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        Stack<String> strings = new Stack<>();
        Stack<Integer> count = new Stack<>();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                count.push(num);
                i--;
            } else if (s.charAt(i) == '[') {
                strings.push(str);
                str = "";
            } else if (s.charAt(i) == ']') {
                int times = count.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
                str = strings.pop() + sb.toString();
            } else {
                str = str + s.charAt(i);
            }
        }
        return str;
    }


}
