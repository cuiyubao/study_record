package com.study.sort.temp;

import com.study.leetcode.ListNode;

import java.util.List;

/**
 * @Author cuiyubao
 * @Date 2021/10/16 9:19 下午
 */
public class ReverseList {


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        printList(node1);
        printList(reverseRecursive(node1));

    }

    //1->2->3->4
    public static ListNode reverse(ListNode listNode) {
        //前一个节点
        ListNode pre = null;
        //当前节点
        ListNode now = listNode;
        //下一个节点
        ListNode next;
        //当前节点不等于null继续执行
        while (now != null) {
            //暂存next节点
            next = now.next;
            //改变指向的下一个节点
            now.next = pre;
            //前一个节点前进
            pre = now;
            //当前节点前进
            now = next;
        }
        return pre;
    }


    /**
     * 递归反转
     * @param listNode 
     * @return
     */
    public static ListNode reverseRecursive(ListNode listNode){
        if (listNode==null||listNode.next==null){
            System.out.println("re："+listNode.val);
            return listNode;
        }
        ListNode recursive = reverseRecursive(listNode.next);
        listNode.next.next=listNode;
        listNode.next=null;
        System.out.println("-:"+recursive.val);
        System.out.println(">>:"+listNode.val);
        return recursive;

    }



    public static void printList(ListNode listNode) {
        StringBuffer stringBuffer = new StringBuffer();
        while (listNode != null) {
            stringBuffer.append(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println(stringBuffer.toString());
    }


}
