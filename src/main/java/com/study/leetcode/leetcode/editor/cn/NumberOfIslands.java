package com.study.leetcode.leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1547 👎 0


public class NumberOfIslands {

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int result = 0;
            int x = grid.length;
            int y = grid[0].length;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == '1') {
                        result++;
                        dfs(grid,i,j);
                    }
                }
            }
            return result;
        }

        public void dfs(char[][] grid, int x, int y) {
            int m = grid.length;
            int n = grid[0].length;
            if (x > m - 1 || x < 0 || y < 0 || y > n - 1) {
                return;
            }
            if (grid[x][y] == '0') {
                return;
            }
            grid[x][y] = '0';
            dfs(grid, x + 1, y);
            dfs(grid, x - 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x, y - 1);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


