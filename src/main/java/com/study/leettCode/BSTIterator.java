package com.study.leettCode;


import com.study.DataStructure.Solution;
import com.study.DataStructure.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树迭代器
 *
 * @author cuiyubao
 * @date 2020/8/23 下午 01:06
 */
public class BSTIterator {
    Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        if(root!=null){
            zhong(root);
        }
    }

    public void zhong(TreeNode root) {
        if (root.left != null) {
            zhong(root.left);
        }
        queue.offer(root.val);
        if (root.right != null) {
            zhong(root.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !queue.isEmpty();
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
        System.out.println(bstIterator.queue);

    }

}