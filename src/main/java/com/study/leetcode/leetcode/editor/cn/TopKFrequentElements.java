package com.study.leetcode.leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 917 👎 0


import org.mockito.internal.matchers.CompareTo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        solution.topKFrequent(new int[]{1,1,1,2,2,2,3,3,3}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
            PriorityQueue<int[]> queue1 = new PriorityQueue<>((int[] o1, int[] o2) -> {
                return o1[1] - o2[1];
            });
            map.forEach((key,value)->{
                queue.add(new int[]{key,value});
                if (queue.size()>k){
                    queue.poll();
                }
            });
           int[] result=new int[k];
            for (int i = 0; i <k; i++) {
                result[i]=queue.poll()[0];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


