package com.study.DataStructure.tree;


/**
 * @author cuiyubao
 * @date 2020/8/23 下午 01:08
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x, TreeNode leftNode, TreeNode rightNode) {
        val = x;
        left = leftNode;
        right = rightNode;
    }
}
