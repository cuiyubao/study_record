package com.study.leetcode.leetcode.editor.cn;
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 797 👎 0


import com.study.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleIi {

    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node2;
        solution.detectCycle(node1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {


        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                //fast遇到空指针说明没环
                return null;
            }
            //重新指向头结点
            slow = head;
            //快慢指针同步前进，相交点就是环起点
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        /**
         * 使用双指针[伪双指针，官方题解中的双指针对比快慢指针走的路程分析]
         *
         * @param head
         * @return
         */
        public ListNode detectCycle1(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode checkNode = head;
            while (checkNode != null) {
                ListNode check = check(checkNode);
                if (check == null) {
                    checkNode = checkNode.next;
                } else {
                    return check;
                }
            }
            return null;
        }

        public ListNode check(ListNode checkNode) {
            int number = 0;
            ListNode node = checkNode.next;
            while (node != null) {
                if (checkNode == node) {
                    return checkNode;
                }
                node = node.next;
                number++;
                if (number > 10000) {
                    break;
                }
            }
            return null;
        }

        /**
         * 使用额外空间的解法
         *
         * @param head
         * @return
         */
        public ListNode detectCycle2(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                int pre = set.size();
                set.add(head);
                if (set.size() == pre) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


