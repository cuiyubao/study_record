package com.study.leetcode;

/**
 * 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * User: cuiyubao
 * Date: 2019/5/3
 * Time: 下午 11:49
 */
public class RemoveDuplicates {
    public static void main(String[] args){
           int[] n=new int[]{0,0,1,1,1,2,2,3,3,4};
     removeDuplicates1(n);

    }

    /**
     * 自己的返回结果正确  但没按照题意来的
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int m=0;
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]==nums[i+1]){
               m++;
               nums[i+1]=nums[i+2];
            }
        }
           return nums.length-m;
    }

    /**
     * 合乎题意的   直接找到不重复的
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        int count = 1;
        int tmp = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != tmp){
                tmp = nums[i];
                nums[count] = tmp;
                count++;
            }
        }
        return count;
    }

}
