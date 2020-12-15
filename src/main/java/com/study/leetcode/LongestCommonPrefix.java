package com.study.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * User: cuiyubao
 * Date: 2019/4/27
 * Time: 下午 05:23
 */
public class LongestCommonPrefix {
    public static void main(String[] args){
       System.out.println(longestCommonPrefix0(new String[]{"a","a"}));
    }

    public static String longestCommonPrefix0(String[] strs) {
        String prefix="";
        int index=0;
        while (true){
            if (strs.length==0)
                return "";
            if (strs.length==1)
                return strs[0];

            for (int i = 0; i < strs.length; i++) {
                if(strs[i].length()==0){
                    return "";
                }
                if(i==0){
                    prefix=prefix+ String.valueOf(strs[0].charAt(index));
                }else{
                    if(!strs[i].startsWith(prefix))
                        return prefix.substring(0,prefix.length()-1);
                }

            }
            index++;
            if(index==strs[0].length())
                return strs[0];
        }
    }
}
