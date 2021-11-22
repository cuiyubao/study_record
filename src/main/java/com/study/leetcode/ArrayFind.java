package com.study.leetcode;

/**
 * User: cuiyubao
 * Date: 2019/4/24
 * Time: 上午 12:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class ArrayFind {
    
    public static void main(String[] args){
        int [] array=new int[4];
        array[0]=2;
        array[1]=7;
        array[2]=11;
        array[3]=15;
        System.out.println(twoSum1(array,9));
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int [] arrayIn=new int[2];
        int size=nums.length;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(nums[i]+nums[j]==target){
                    arrayIn[0]=i+1;
                    arrayIn[1]=j+1;
                }
            }
        }
        return arrayIn;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] arrayIn = new int[2];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                arrayIn[0] = i+1;
                arrayIn[1] = j+1;
                break;
            }
        }
        return arrayIn;
    }


}