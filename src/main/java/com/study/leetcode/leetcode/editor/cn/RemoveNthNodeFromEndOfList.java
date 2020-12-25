package com.study.leetcode.leetcode.editor.cn;
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
// 👍 1154 👎 0


import com.study.leetcode.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        System.out.println(solution.removeNthFromEnd(node1, 5).val);
        solution.removeNthFromEnd(node1, 5);
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
            int number=1;
            ListNode pre=new ListNode(0,head);
            ListNode nextRunNode=new ListNode(0,null);
            ListNode runNode=head;
            while (runNode!=null){
                System.out.println(runNode.val);
                if(number>=n){
                    if(nextRunNode.next==null){
                        nextRunNode=pre;
                    }else {
                        nextRunNode=nextRunNode.next;
                    }
                }
                runNode=runNode.next;
                number++;
            }
            nextRunNode.next=nextRunNode.next.next;
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


