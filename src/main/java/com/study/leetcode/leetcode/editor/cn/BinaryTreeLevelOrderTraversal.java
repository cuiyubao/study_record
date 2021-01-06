package com.study.leetcode.leetcode.editor.cn;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 742 👎 0


import com.study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution=new BinaryTreeLevelOrderTraversal().new Solution();

    }
 
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList();
        int size=1;
        queue.add(root);
        while (!queue.isEmpty()){
            int temp=size;
            size=0;
            List<Integer> addNodeList = new ArrayList<>();
            for (int i = 0; i < temp; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                    size++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    size++;
                }
                addNodeList.add(node.val);
            }
            resultList.add(addNodeList);
        }
        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


