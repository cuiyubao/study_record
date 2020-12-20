package com.study.leetcode;

/**
 * User: cuiyubao
 * Date: 2019/4/24
 * Time: 下午 11:02
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x,ListNode node) {
        val = x;
        next = node;
    }
    public ListNode(int x) {
        val = x;
        next = null;
    }
}
