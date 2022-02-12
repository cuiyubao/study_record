package com.study.leetcode.leetcode.editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1450 👎 0


import com.study.leetcode.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode node5 = new ListNode(5, null);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);


        ListNode node6 = new ListNode(6, null);
        ListNode node4 = new ListNode(4, node6);
        ListNode node2 = new ListNode(2, node4);

        solution.mergeTwoLists(node1, node2);


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
            //虚拟头结点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while (node1 != null && node2 != null) {
                //比较节点两个指针
                //将值较小的执行p指针
                if (node1.val > node2.val) {
                    p.next = node2;
                    node2 = node2.next;
                } else {
                    p.next = node1;
                    node1 = node1.next;
                }
                //p指针不断前进
                p=p.next;
            }
            if (node1 == null) {
                p.next = node2;
            }
            if (node2 == null) {
                p.next = node1;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


