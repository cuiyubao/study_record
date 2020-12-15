package com.study.leetcode;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1146 👎 0


public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(solution.removeNthFromEnd(node1, 5).val);

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
//        //定义哨兵
//        ListNode sentinel = new ListNode(0);
//        sentinel.next = head;
//        ListNode node = sentinel;//指向头结点的指针用于移动,领先current结点n步
//        ListNode current = sentinel;//需要删除的结点指针，当head遍历到尾部即是要删除的结点
//        ListNode pre = sentinel;//用于操作删除current结点
//        int i = 1;//记录步数
//        while (node != null && node.next != null) {
//            if (i >= n) {
//                pre = current;
//                current = current.next;
//            }
//            node = node.next;
//            i++;
//        }
//        pre.next = pre.next.next;
//        return sentinel.next;

            int length = 1;
            int index = 0;
            ListNode node = head;
            while (node.next != null) {
                node = node.next;
                length++;
            }
            if (index == (length - n)) {
                return head.next;
            }
            node = head;
            while (node.next != null) {
                index++;
                if (index == (length - n)) {
                    node.next = node.next.next;
                    break;
                }
                node = node.next;
            }
            return head;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


