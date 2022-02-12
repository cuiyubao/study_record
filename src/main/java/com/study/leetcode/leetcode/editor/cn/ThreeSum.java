package com.study.leetcode.leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4291 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] array = {3,0,-2,-1,1,2};
        solution.threeSum(array);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                // 穷举 threeSum 的第一个数
                int num = nums[i];
                // 对 target - nums[i] 计算 twoSum
                List<List<Integer>> twoSumList = twoSum(nums, i+1, 0 - num);
                // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
                if (twoSumList.size() > 0) {
                    for (List<Integer> list : twoSumList) {
                        list.add(num);
                    }
                    result.addAll(twoSumList);
                }
                // 跳过第一个数字重复的情况，否则会出现重复结果
                while (i < nums.length-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
            return result;
        }


        public List<List<Integer>> twoSum(int[] nums, int start, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            // 左指针改为从 start 开始，其他不变
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int sum = leftNum + rightNum;
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
                if (sum == target) {
                    List<Integer> item = new ArrayList<>();
                    item.add(leftNum);
                    item.add(rightNum);
                    result.add(item);
                    while (left < right && nums[left] == leftNum) {
                        left++;
                    }
                    while (left < right && nums[right] == rightNum) {
                        right--;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


