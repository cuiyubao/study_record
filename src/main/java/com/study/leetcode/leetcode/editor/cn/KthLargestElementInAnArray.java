package com.study.leetcode.leetcode.editor.cn;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1380 👎 0


public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(new int[]{1},1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            //先排序
            quickSort(nums,0,nums.length-1);
            int pre=Integer.MIN_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
               int num=nums[i];
                if (num!=pre){
                    k--;
                }
                if (k==0){
                    return num;
                }
            }
            return 0;
        }

        /**
         * 快速排序
         *
         * @param nums
         * @param begin
         * @param end
         */
        public void quickSort(int[] nums, int begin, int end) {
            if (begin < end) {
                //基准值
                int key = nums[begin];
                int i = begin;
                int j = end;
                while (i < j) {
                    while (i < j && nums[j] > key) {
                        j--;
                    }
                    if (i < j) {
                        nums[i] = nums[j];
                        i++;
                    }
                    while (i < j && nums[i] < key) {
                        i++;
                    }
                    if (i < j) {
                        nums[j]=nums[i];
                        j--;
                    }
                }
                nums[i]=key;
                quickSort(nums,begin,i-1);
                quickSort(nums,i+1,end);
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


