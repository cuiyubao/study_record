package com.study.leetcode.leetcode.editor.cn;
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 370 👎 0


import com.study.leetcode.common.TreeNode;
import lombok.val;

public class DeleteNodeInABst {

    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
        TreeNode root=init();
        solution.deleteNode(root,4);


    }



    public static TreeNode init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        TreeNode F = new TreeNode(7, null, null);
        TreeNode E = new TreeNode(4, null, null);
        TreeNode D = new TreeNode(2, null, null);
        TreeNode C = new TreeNode(6, null, F);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(5, B, C);
        return A;   //返回根节点
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (key > root.val) {
                //递归去右边子树删除
                root.right = deleteNode(root.right, key);
            } else if (key < root.val) {
                //递归去左子树删除
                root.left = deleteNode(root.left, key);
            } else {
                //找到了要删除的节点

                //若节点为叶子节点  直接删除
                if (root.left == null && root.right == null) {
                    root = null;

                } else if (root.right != null && root.left == null) {
                    root = root.right;

                } else if (root.right == null && root.left != null) {
                    root = root.left;
                }else {
                    TreeNode predecessor = predecessor(root);
                    deleteNode(root,predecessor.val);
                    root.val=predecessor.val;

                }
            }
            return root;
        }

        /**
         * 获取一个节点的前驱节点
         *
         * @param node
         * @return
         */
        public TreeNode predecessor(TreeNode node) {
            TreeNode resultNode = node.left;
            while (resultNode.right != null) {
                resultNode = resultNode.right;
            }
            return resultNode;
        }

        /**
         * 获取一个节点的后继节点
         *
         * @param node
         * @return
         */
        public TreeNode successor(TreeNode node) {
            TreeNode resultNode = node.right;
            while (resultNode.left != null) {
                resultNode = resultNode.left;
            }
            return resultNode;
        }





        public TreeNode deleteNode1(TreeNode root, int key) {
            TreeNode result=root;
            while (root!=null){
                if (root.val == key) {
                    if (root.left == null && root.right == null) {
                        root = null;
                        break;
                    } else if (root.left == null && root.right != null) {
                        root = root.right;
                        break;
                    } else if (root.left != null && root.right == null) {
                        root = root.left;
                        break;
                    } else {
                        TreeNode treeNode = searchMaxNode(root.left);
                        root.val=treeNode.val;
                        treeNode=null;
                        break;
                    }
                }else{
                     if(key>root.val){
                         root=root.right;
                     }else {
                         root=root.left;
                     }
                }
            }

            return result;
        }

        public TreeNode searchMaxNode(TreeNode node){
           int result=0;
           while (null!=node){
               if(node.right!=null){
                   if(node.right==null){
                       return node;
                   }else{
                       node=node.right;
                   }
               }else{
                  return node;
               }
           }
           return null;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


