package com.study.leetcode;


import com.study.DataStructure.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树迭代器
 *
 * @author cuiyubao
 * @date 2020/8/23 下午 01:06
 */
public class BSTIterator {
    //    Queue<Integer> queue = new LinkedList<>();
//
//    public BSTIterator(TreeNode root) {
//        if(root!=null){
//            zhong(root);
//        }
//    }
//
//    public void zhong(TreeNode root) {
//        if (root.left != null) {
//            zhong(root.left);
//        }
//        queue.offer(root.val);
//        if (root.right != null) {
//            zhong(root.right);
//        }
//    }
//
//    /**
//     * @return the next smallest number
//     */
//    public int next() {
//        return queue.poll();
//    }
//
//    /**
//     * @return whether we have a next smallest number
//     */
//    public boolean hasNext() {
//        return !queue.isEmpty();
//    }
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        // 递归模拟堆栈
        this.stack = new Stack<TreeNode>();

        // 请记住，该算法始于以根节点为输入的对helper函数的调用
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {
        System.out.println(stack.stream().map(m->m.val).collect(Collectors.toList()));
        // 对于给定的节点，将树的最左分支下的所有元素添加到堆栈中。
        while (root != null) {
            this.stack.push(root);
            root = root.left;
            System.out.println(stack.stream().map(m->m.val).collect(Collectors.toList()));
        }
    }

    /**
     * @return 下一个最小的数字
     */
    public int next() {
        System.out.println(stack.stream().map(m->m.val).collect(Collectors.toList()));
        // 堆栈顶部的节点是下一个最小的元素
        TreeNode topmostNode = this.stack.pop();

        //需要保持不变。如果节点有合适的子代，请为合适的子代调用 helper函数
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }
        System.out.println(stack.stream().map(m->m.val).collect(Collectors.toList()));
        return topmostNode.val;
    }

    /**
     * @return我们是否有下一个最小的数字
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }


    public static TreeNode init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;   //返回根节点
    }

    public static void main(String[] args) {
        TreeNode initRoot = init();

        BSTIterator bstIterator = new BSTIterator(initRoot);
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
    }

}