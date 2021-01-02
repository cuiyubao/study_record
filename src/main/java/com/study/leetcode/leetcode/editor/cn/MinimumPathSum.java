package com.study.leetcode.leetcode.editor.cn;
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 751 👎 0


import java.util.ArrayList;
import java.util.List;

public class MinimumPathSum {

    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        int[][] aa={{1,3,1},{1,5,1},{4,2,1}};
        solution.minPathSum(aa);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            dp[0][0] = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                int[] data = grid[i];
                for (int j = 0; j < data.length; j++) {
                    if (i == 0 && j != 0) {
                        dp[0][j] = dp[0][j - 1] + grid[0][j];
                    } else if (j == 0 && i != 0) {
                        dp[i][0] = dp[i - 1][0] + grid[i][0];
                    } else if (j > 0 && i > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                    }
                }
            }
            return dp[grid.length-1][grid[0].length-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


