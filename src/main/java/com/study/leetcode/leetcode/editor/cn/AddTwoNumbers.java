package com.study.leetcode.leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5421 👎 0


import com.study.leetcode.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            int temp = 0;
            ListNode dumpNode = new ListNode(0, null);
            ListNode result = dumpNode;
            while (l1 != null || l2 != null) {
                int a = l1 != null ? l1.val : 0;
                int b = l2 != null ? l2.val : 0;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                int add = (a + b + temp) % 10;
                temp = (a + b + temp) / 10;
                result.next = new ListNode(add, null);
                result = result.next;
            }
            if (temp > 0) {
                result.next = new ListNode(temp, null);
            }
            return dumpNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


