package com.study.leetcode.leetcode.editor.cn;
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1750 👎 0


import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution=new MergeKSortedLists().new Solution();
        ListNode[] lists=new ListNode[2];
        ListNode node0 = new ListNode(-1);
        ListNode node1 = new ListNode(-1,node0);
        ListNode node2 = new ListNode(-2,node1);
        lists[0]=node2;
        lists[1]=null;
        solution.mergeKLists(lists);
    }
 
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);

        for (ListNode x : lists)
        {
            while (x != null)
            {
                minHeap.offer(x);
                x = x.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode x = dummy;
        while (!minHeap.isEmpty())
        {
            ListNode node= minHeap.poll();
            x.next =node;
            x = x.next;
        }
        return dummy.next;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}


