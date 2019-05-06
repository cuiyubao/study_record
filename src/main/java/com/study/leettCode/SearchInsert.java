package com.study.leettCode;

/**给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
 输出: 2
 示例 2:

 输入: [1,3,5,6], 2
 输出: 1
 示例 3:

 输入: [1,3,5,6], 7
 输出: 4
 示例 4:

 输入: [1,3,5,6], 0
 输出: 0
 * User: cuiyubao
 * Date: 2019/5/5
 * Time: 下午 11:45
 */
public class SearchInsert {
    public static void main(String[] args) {
System.out.println(searchInsert(new int[]{4},6));
    }

    public static int searchInsert(int[] nums, int target) {
        int result=0;
        if(nums.length==0||target<nums[0])
            return result;
        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]){
                result=i;
                break;
            }else if(i<nums.length-1){
                if(target>nums[i]&&target<nums[i+1]){
                    result=i+1;
                    break;
                }
            }else if(i==nums.length-1){
                if(target>nums[i]){
                    result=i+1;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 简洁的代码
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
