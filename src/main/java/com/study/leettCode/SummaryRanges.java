package com.study.leettCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * User: cuiyubao
 * Date: 2019/4/28
 * Time: 下午 10:22
 */
public class SummaryRanges {
    public static void main(String[] args){

    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> put=new ArrayList<>();
        List<String> re=new ArrayList<>();
        if (nums.length==0)
            return re;
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                put.add(String.valueOf(nums[0]));
            }else {
                if(nums[i]-nums[i-1]==1){
                    put.add(String.valueOf(nums[i]));
                }else{
                    re.add(String.join("->",getStartAndEnd(put)));
                    put.clear();
                    put.add(String.valueOf(nums[i]));
                }
            }
        }
        re.add(String.join("->",getStartAndEnd(put)));
        return re;
    }
    public static List<String> getStartAndEnd(List<String> list){
        List<String> re=new ArrayList<>();
        if(list.size()>1){
            re.add(list.get(0));
            re.add(list.get(list.size()-1));
        }else {
            re=list;
        }
        return  re;
    }

}
