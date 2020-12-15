package com.study.leetcode;
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划 
// 👍 570 👎 0


public class BestTimeToBuyAndSellStockIii {

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        int[] prices = new int[]{
                1,2,3,4,5
        };
        System.out.println(solution.maxProfit(prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
//        if (prices == null || prices.length <= 1) return 0;
//        int[][][] dp = new int[prices.length][2][3];
//        int MIN_VALUE = Integer.MIN_VALUE / 2;//因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
//        //初始化
//        dp[0][0][0] = 0;//第一天休息
//        dp[0][0][1] = dp[0][1][1] = MIN_VALUE;//不可能
//        dp[0][0][2] = dp[0][1][2] = MIN_VALUE;//不可能
//        dp[0][1][0] = -prices[0];//买股票
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0][0] = 0;
//            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
//            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
//            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
//            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
//            dp[i][1][2] = MIN_VALUE;
//        }
//        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int s1 = -prices[0];
            int s2 = Integer.MIN_VALUE;
            int s3 = Integer.MIN_VALUE;
            int s4 = Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
//                int s1_ = s1;
//                int s2_ = s2;
//                int s3_ = s3;
//                int s4_ = s4;
                s1 = Math.max(s1, -prices[i]);
//                System.out.println("第" + (i + 1) + "天： [第一次买入价格更低的股票 ] s1：" + s1 + " 原s1: " + s1_ + "  比较值：" + -prices[i]);
                s2 = Math.max(s2, s1 + prices[i]);
//                System.out.println("第" + (i + 1) + "天： [第一次卖出当前股票或不操作]s2：" + s2 + " 原s2:" + s2_ + "  比较值：" + (s1 + prices[i]));
                s3 = Math.max(s3, s2 - prices[i]);
//                System.out.println("第" + (i + 1) + "天： [第二次买入或者不操作]     s3：" + s3 + " 原s3:" + s3_ + "  比较值：" + (s2 - prices[i]));
                s4 = Math.max(s4, s3 + prices[i]);
//                System.out.println("第" + (i + 1) + "天： [第二次卖出或者不操作]     s4：" + s4 + " 原s4:" + s4_ + "  比较值：" + (s3 + prices[i]));
//                System.out.println();
            }
            return Math.max(0, s4);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


