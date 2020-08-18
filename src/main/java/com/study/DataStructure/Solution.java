package com.study.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cuiyubao
 * @date 2020/8/18 下午 01:39
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode leftNode, TreeNode rightNode) {
            val = x;
            left = leftNode;
            right = rightNode;
        }
    }


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

                //如果右子树不为空，则找到后继节点取代要删除的节点，之后删除后继节点
                //包含的情况[{左不为空，右不为空}，{左为空，右不为空}]
                //注: 这一步相当于一下处理了上面的两种情况，当然这里换成root.left!=null也可以，只要上下交换一下代码就可以，
            } else if (root.right != null) {
                //找到后继节点
                TreeNode successor = successor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);

                //右子树为空,找到前驱节点,取代要删除的节点，之后删除前去节点
                //包含的情况 [{左子树不空,右边子树为空}]
            } else {
                //找到前驱节点
                TreeNode predecessor = predecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode(root.left, predecessor.val);
            }
        }
        return root;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
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

    /**
     * 求二叉树最小深度
     * @param root
     * @return
     */
    public int getMinBSTHight(TreeNode root){
        int size=1;
        int height=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int y=0;
            for (int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left==null&&poll.right==null){
                    return height;
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                    y++;
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                    y++;
                }
            }
            size=y;
            height++;
        }

        return height;
    }





    public TreeNode init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
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


    public List<Integer> zhong(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            zhong(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            zhong(root.right, list);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.init();
//        solution.deleteNode(root, 6);
//        zhongPrint(root);
        solution.getMinBSTHight(root);

    }

    public static void zhongPrint(TreeNode root) {
        Solution solution = new Solution();
        List<Integer> zhong = solution.zhong(root, new ArrayList<>());
        System.out.println("中序遍历:" + zhong);
    }

}
