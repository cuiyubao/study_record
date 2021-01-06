package com.study.leetcode.leetcode.editor.cn;
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归
// 👍 764 👎 0


import com.study.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        /**
         * 通过递归实现
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        /**
         * 通过层序遍历（BFS）实现
         *
         * @param root
         * @return
         */
        public int maxDepth1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int result = 0;
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            //记录一层添加的个数
            int size = 1;
            while (!queue.isEmpty()) {
                //当前层的数
                int temp = size;
                //重置开始记录下一层的数目
                size = 0;
                for (int i = 0; i < temp; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.right != null) {
                        queue.add(poll.right);
                        size++;
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                        size++;
                    }
                }
                result++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


