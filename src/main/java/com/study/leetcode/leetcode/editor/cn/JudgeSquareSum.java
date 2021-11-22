package com.study.leetcode.leetcode.editor.cn;

import com.study.leetcode.ListNode;

/**
 * 平方数之和
 *
 * @Author cuiyubao
 * @Date 2021/11/22 3:26 下午
 */
public class JudgeSquareSum {

    //leetcode submit region begin(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new JudgeSquareSum().new Solution();
        System.out.println(solution.judgeSquareSum(2147483600));
    }


    public class Solution {
        public boolean judgeSquareSum(int c) {
            if (c < 0) return false;
            long i = 0, j = (long) Math.sqrt(c);
            while (i <= j) {
                long sum = i * i + j * j;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
