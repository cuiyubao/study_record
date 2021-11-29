package com.study.leetcode.leetcode.editor.cn;
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心 数组 动态规划 排序 👍 548 👎 0


import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(1);
        Solution solution=new NonOverlappingIntervals().new Solution();
        int[][] intervals=new int[][]{new int[]{1,2},new int[]{2,3},new int[]{3,4},new int[]{1,3}};
        solution.eraseOverlapIntervals(intervals);
    }
 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1]-o2[1]);
        int size=0;
        int[] pre=intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>=pre[1]) {
                pre=intervals[i];
            }else {
                size++;
            }
        }
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


