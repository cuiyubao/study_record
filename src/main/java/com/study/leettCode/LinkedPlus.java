package com.study.leettCode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * User: cuiyubao
 * Date: 2019/4/24
 * Time: 下午 10:55
 */
public class LinkedPlus {
    public static void main(String[] args) {
        ListNode node= new ListNode(9);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(9);
        node.next = node2;
        node2.next = node3;
        ListNode node1= new ListNode(5);
        ListNode node21 = new ListNode(6);
//        ListNode node31 = new ListNode(4);
        node1.next = node21;
//        node21.next = node31;
//      ListNode listNode=addTwoNumbers(node,node1);
//      ListNode listNode=addTwoNumbers(node,node1);
      ListNode listNode=addTwoNumbers2(node,node1);
    }
//自己写的垃圾
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        String a = "";
//        String b = "";
//
//        while (String.valueOf(l1.val).length()>0) {
//            a = a + l1.val;
//            l1 = l1.next;
//            if(l1==null)break;
//        }
//        while (String.valueOf(l2.val).length()>0) {
//            b = b + l2.val;
//            l2 = l2.next;
//            if(l2==null)break;
//        }
//        String c = String.valueOf((Long.parseLong(new StringBuilder(a).reverse().toString()) + Long.parseLong(new StringBuilder(b).reverse().toString())));
//        c = new StringBuilder(c).reverse().toString();
//        char[] d = c.toCharArray();
//        String e = "";
//        ListNode nodeR = null;
//        ListNode node = null;
//        for (int i = 0; i<d.length; i++) {
//
//            ListNode no = new ListNode(Integer.parseInt(String.valueOf(d[i])));
//            if (i ==0) {
//                nodeR = no;
//                node=no;
//            } else {
//                node.next = no;
//                node=no;
//            }
//        }
//        return nodeR;
//    }

    /**
     * 答案
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            System.out.println(point);
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;

        }

        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }

        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }

        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        // 寻找长的list
        while(node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        // 判断长度
        if(node2 == null) {
            node1 = l1;
            node2 = l2;
        } else {
            node1 = l2;
            node2 = l1;
        }
        ListNode result = new ListNode(0);
        ListNode node = result;
        // node2 是较短的那个(可能同样长)
        while(node2 != null) {
            // 求和
            int sum = node1.val + node2.val + node.val;
            node.val = sum % 10;
            // 进位
            int mod = sum / 10;
            if(mod > 0 || node1.next != null) {
                node.next = new ListNode(mod);
                node = node.next;
            }
            // 后移
            node1 = node1.next;
            node2 = node2.next;
        }
        while(node1 != null) {
            // 求和
            int sum = node1.val + node.val;
            node.val = sum % 10;
            // 进位
            int mod = sum / 10;
            if(mod > 0 || node1.next != null) {
                node.next = new ListNode(mod);
                node = node.next;
            }
            node1 = node1.next;
        }
        return result;
    }



}
