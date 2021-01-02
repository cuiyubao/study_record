package com.study.leetcode.leetcode.editor.cn;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2431 👎 0


public class ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        solution.reverse(2147483647);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 自己写的
         * @param x
         * @return
         */
        public int reverse(int x) {
            Long num;
            boolean isNegative = false;
            String s = String.valueOf(x);
            if (s.startsWith("-")) {
                s = s.substring(1);
                isNegative = true;
            }
            s = new StringBuilder(s).reverse().toString();
            num = Long.valueOf(s);
            if (isNegative) {
                num = -num;
            }
            if(num>Integer.MAX_VALUE||num<Integer.MIN_VALUE){
                return 0;
            }
            return num.intValue();
        }

        /**
         * 官方解法
         * 通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。
         * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
         * 从ans * 10 + pop > MAX_VALUE这个溢出条件来看
         *      当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
         *      当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
         * 从ans * 10 + pop < MIN_VALUE这个溢出条件来看
         *      当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
         *      当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
         * @param x
         * @return
         */
        public int reverse1(int x) {
            int ans = 0;
            while (x != 0) {
                int pop = x % 10;
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }
                ans = ans * 10 + pop;
                x /= 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


