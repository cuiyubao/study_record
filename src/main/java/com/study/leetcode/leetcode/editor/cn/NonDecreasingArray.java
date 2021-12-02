package com.study.leetcode.leetcode.editor.cn;
//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
//
// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 👍 633 👎 0


public class NonDecreasingArray {

    public static void main(String[] args) {
        Solution solution = new NonDecreasingArray().new Solution();
        System.out.println(solution.checkPossibility(new int[]{3, 4, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这道题给了我们一个数组，说我们最多有1次修改某个数字的机会，
         *   问能不能将数组变为非递减数组。题目中给的例子太少，不能覆盖所有情况，我们再来看下面三个例子：
         * 	4，2，3
         * 	-1，4，2，3
         * 	2，3，3，2，4
         * 我们通过分析上面三个例子可以发现，当我们发现后面的数字小于前面的数字产生冲突后，
         * [1]有时候需要修改前面较大的数字(比如前两个例子需要修改4)，
         * [2]有时候却要修改后面较小的那个数字(比如前第三个例子需要修改2)，
         * 那么有什么内在规律吗？是有的，判断修改那个数字其实跟再前面一个数的大小有关系，
         * 首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
         * 而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
         * 如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。
         * @param nums
         * @return
         */
        public boolean checkPossibility(int[] nums) {
            //要做的改变量
            int size = 0;
            for (int i = 1; i < nums.length && size < 2; i++) {
                  if (nums[i]>=nums[i-1]){
                      continue;
                  }
                  size++;
                  if (i-2>=0&&nums[i-2]>nums[i]){
                      nums[i]=nums[i-1];
                  }else {
                      nums[i-1]=nums[i];
                  }
            }
            return size<=1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


