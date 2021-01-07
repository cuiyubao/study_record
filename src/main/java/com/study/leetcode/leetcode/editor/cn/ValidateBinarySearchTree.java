package com.study.leetcode.leetcode.editor.cn;
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 879 👎 0


import com.study.leetcode.common.TreeNode;
import com.study.leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode tree = TreeUtil.createTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        List<Integer> integers = solution.inOrder(tree, new ArrayList<>());
        System.out.println(integers);

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
         * 通过递归判断
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            return checkBST(root, null, null);
        }

        public boolean checkBST(TreeNode treeNode, Integer min, Integer max) {
            if (treeNode == null) {
                return true;
            }
            if (min != null && treeNode.val <= min) {
                return false;
            }
            if (max != null && treeNode.val >= max) {
                return false;
            }
            return checkBST(treeNode.left, min, treeNode.val) && checkBST(treeNode.right, treeNode.val, max);
        }


        /**
         * 通过中序遍历获取从小到大的值,之后判断获取的是否是真正的从小到大，不是返回false
         *
         * @param root
         * @return
         */
        public boolean isValidBST1(TreeNode root) {
            if (root == null) {
                return false;
            }
            List<Integer> list = inOrder(root, new ArrayList<>());
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) <= list.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 中序遍历
         *
         * @param root
         * @param list
         * @return
         */
        private List<Integer> inOrder(TreeNode root, List<Integer> list) {
            if (root.left != null) {
                inOrder(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                inOrder(root.right, list);
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


