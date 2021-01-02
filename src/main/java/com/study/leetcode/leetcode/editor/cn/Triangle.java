package com.study.leetcode.leetcode.editor.cn;
//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 666 👎 0


import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        a.add(2);
        b.add(3);
        b.add(4);
        c.add(6);
        c.add(5);
        c.add(7);
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        data.add(a);
        data.add(b);
        data.add(c);
        data.add(d);
        System.out.println(data);
        solution.minimumTotal(data);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
            dp[0][0] = triangle.get(0).get(0);
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> data = triangle.get(i);
                for (int j = 0; j < data.size(); j++) {
                    if (j == 0) {
                        dp[i][0] = dp[i - 1][0] + data.get(j);
                    } else if (j == data.size() - 1) {
                        dp[i][j] = dp[i - 1][j - 1] + data.get(j);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + data.get(j), dp[i - 1][j] + data.get(j));
                    }
                }
            }
            int[] findMinData = dp[triangle.size() - 1];
            for (int i = 0; i < findMinData.length; i++) {
                if (findMinData[i] < result) {
                    result = findMinData[i];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


