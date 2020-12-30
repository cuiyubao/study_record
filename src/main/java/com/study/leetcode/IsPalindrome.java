package com.study.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * User: cuiyubao
 * Date: 2019/4/27
 * Time: 上午 12:08
 */
public class IsPalindrome {
    public static void main(String[] args) {
        isPalindromeDaAn(121);
    }

    public static boolean isPalindrome(int x) {
        return   new StringBuffer(String.valueOf(x)).reverse().toString().equals(String.valueOf(x));
    }

    /**
     * 比较好的做法
     * @param x
     * @return
     */
    public static boolean isPalindromeDaAn(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }
}
/**
 * 1234
 *         param/10  param%10
 *  param    商       余数   end
 *  1234    123       4      4
 *  123     12        3     43
 *  12      1         2     432
 *  1       0         1     4321
 *
 *
 *
 *
 *
 **/