package com.study.leetcode.leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1333 👎 0


public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.getRight(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            return new int[]{getLeft(nums, target), getRight(nums, target)};
        }

        public int getLeft(int[] nums, int target) {
            //始终记住：搜索范围[left,right)
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] > target) {
                    //搜索范围[left,right)
                    right = mid;
                }
            }
            //target比所有数都大
            if (left == nums.length) {
                return -1;
            }
            //target没有找见 但 nums[0]<target<nums[nums.length-1]
            if (nums[left] != target) {
                return -1;
            }
            return left;
        }

        public int getRight(int[] nums, int target) {
            //始终记住：搜索范围[left,right)
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    //搜索范围[left,right)
                    right = mid;
                }
            }
            //比所有数都小
            if (left == 0) {
                return -1;
            }
            //target没有找见 但 nums[0]<target<nums[nums.length-1]
            if (nums[left - 1] != target) {
                return -1;
            }
            return left - 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


