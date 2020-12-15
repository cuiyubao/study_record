package com.study.leetcode;

/**给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * User: cuiyubao
 * Date: 2019/4/25
 * Time: 下午 11:30
 */
public class Reverse {
    public static void main(String[] args) {
//      new Reverse().reverse(1534236469);
      new Reverse().reverseInteger(1534236469);
    }

    /**
     * 自己写的
     * 转换有问题的就是有益处的情况
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result;
        try {
            if(x<0){
                String a=String.valueOf(x).substring(1,String.valueOf(x).length());
                result= 0-Integer.parseInt(new StringBuilder(a).reverse().toString());
            }else {
              result=  Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());

            }
        } catch (NumberFormatException e) {
            result=0;
        }
        System.out.println(result);
        return  result;
    }

    /**
     * 答案
     * @param n
     * @return
     */
    public int reverseInteger(int n) {
        int reversed_n = 0;

        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }
}

