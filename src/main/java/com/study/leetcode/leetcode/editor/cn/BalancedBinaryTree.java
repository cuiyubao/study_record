package com.study.leetcode.leetcode.editor.cn;
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 558 👎 0


import com.study.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();

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
         * 自底向上判断
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) >= 0 ? true : false;
        }

        public int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            } else {
                return Math.max(left, right) + 1;
            }
        }


        /**
         * 自顶向下判断
         *
         * @param root
         * @return
         */
        public boolean isBalanced1(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isBalanced1(root.left) || !isBalanced1(root.right)) {
                return false;
            }
            int left = getMaxDepth(root.left);
            int right = getMaxDepth(root.right);
            if (Math.abs(left - right) <= 1) {
                return true;
            }
            return false;
        }


        public int getMaxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


