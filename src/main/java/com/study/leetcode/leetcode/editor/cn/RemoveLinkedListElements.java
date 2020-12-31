package com.study.leetcode.leetcode.editor.cn;
//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 505 👎 0


import com.study.leetcode.ListNode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode cur=dummyNode;
            while (cur.next!= null) {
                if (cur.next.val == val) {
                    cur.next=cur.next.next;
                }else {
                    cur=cur.next;
                }
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


