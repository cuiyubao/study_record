package com.study.DataStructure;

import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author cuiyubao
 * @date 2020/8/18 下午 01:39
 */
public class Solution {
    public static class TreeNode {
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
            } else {
                TreeNode predecessor = predecessor(root);
                deleteNode(root, predecessor.val);
                root.val = predecessor.val;
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
     *
     * @param root
     * @return
     */
    public int getMinBSTHight(TreeNode root) {
        int size = 1;
        int height = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int y = 0;
            System.out.println("queue长度：" + queue.size());
            System.out.println("size：" + size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return height;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    y++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    y++;
                }
            }
            size = y;
            height++;
        }

        return height;
    }

    /**
     * 求二叉树最小深度
     *
     * @param root
     * @return
     */
    public void treePrint(TreeNode root) {
        int size = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int y = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val + "  ");
                if (poll.left != null) {
                    queue.offer(poll.left);
//                    System.out.print(poll.left.val+"  ");
                    y++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
//                    System.out.print(poll.right.val+"  ");
                    y++;
                }
            }
            size = y;
            System.out.println("");
        }

    }


    /**
     * 获取树的最大深度
     *
     * @param root
     * @return
     */
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.right == null && root.left == null) {
            return 1;
        } else {
            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
        }
    }

    public TreeNode searchTree(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        if (root.left != null) {
            TreeNode treeNode = searchTree(root.left, val);
            if (treeNode != null) {
                return treeNode;
            } else {
                if (root.right != null) {
                    return searchTree(root.right, val);
                }
            }
        }
        if (root.right != null) {
            TreeNode treeNode = searchTree(root.right, val);
            if (treeNode != null) {
                return treeNode;
            } else {
                if (root.left != null) {
                    return searchTree(root.left, val);
                }
            }
        }

        return null;
    }

    public TreeNode searchTree1(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        if (root.left != null) {
            searchTree(root.left, val);
        }
        if (root.right != null) {
            searchTree(root.right, val);
        }
        return null;
    }

    public TreeNode searchTree2(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        if (val > root.val) {
            return searchTree(root.right, val);
        } else {
            return searchTree(root.left, val);
        }
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 二叉搜索树插入
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val, null, null);
        }

        if (val == root.val) {
            return root;
        }
        if (val > root.val) {
            if (root.right == null) {
                TreeNode addNode = new TreeNode(val, null, null);
                root.right = addNode;
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }
        if (val < root.val) {
            if (root.left == null) {
                TreeNode addNode = new TreeNode(val, null, null);
                root.left = addNode;
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        }
        return root;
    }

    /**
     * 将有序数组转换为二叉搜索树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int top = nums.length / 2;
        int num = nums[top];
        TreeNode root = new TreeNode(num, null, null);
        if(top>0){
            root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,top));
            root.right=sortedArrayToBST(Arrays.copyOfRange(nums,top+1,nums.length));
        }
        return root;
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


    /**
     * 是否是真二叉搜索树
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        list = isTrueTree(root, list);
        if (list.size() == 1) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> isTrueTree(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            isTrueTree(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            isTrueTree(root.right, list);
        }
        return list;
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int pre = 0;
        list = zhong(root, list);
        for (int i = 0; i < list.size(); i++) {
            int object = list.get(i);
            if (i != 0) {
                min = Math.min(object - pre, min);
                if (min == 1) {
                    return min;
                }
            }
            pre = object;
        }

        return min;
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

    int pre = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference1(TreeNode root) {
        inOrder(root);
        return min;
    }

    int rangeSum=0;


    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root.left != null) {
            inOrder(root.left);
        }
        if (pre > -1) {
            min = Math.min(min, root.val - pre);
        }
        if(root.val>L&&root.val<R){
            rangeSum+=root.val;
        }
        if (root.right != null) {
            inOrder(root.right);
        }
        return rangeSum;
    }


    public void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        if (pre > -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    /**
     * 两个节点的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        List<TreeNode> pThrough = new ArrayList<>();
        List<TreeNode> qThrough = new ArrayList<>();
        throughNode(root,p.val,pThrough);
        throughNode(root,q.val,qThrough);
        pThrough.retainAll(qThrough);
        return pThrough.get(pThrough.size()-1);
    }

    public List<TreeNode> throughNode(TreeNode root,int val,List<TreeNode> list){
        if(root.val>val){
            list.add(root);
            throughNode(root.left,val,list);
        }else if(root.val<val){
            list.add(root);
            throughNode(root.right,val,list);
        }else{
            list.add(root);
        }
        return list;
    }

    int kFlag=0;
    TreeNode knode=null;
    public int kthSmallest(TreeNode root, int k) {
       return getKnode(root,k).val;
    }

    public TreeNode getKnode(TreeNode root, int k) {
        if (root.left != null) {
            knode= getKnode(root.left,k);
        }
        if(knode!=null){
            return knode;
        }
        kFlag++;
        if(kFlag==k){
            return root;
        }
        if (root.right != null) {
            return getKnode(root.right,k);
        }
        return knode;
    }


    /**
     * 通过栈的方式进行中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.init();
//        solution.deleteNode(root, 6);
//        zhongPrint(root);
//        solution.getMinBSTHight(root);
//        solution.treePrint(root);

//        solution.getMaxDepth(root);

//        solution.levelOrder(root);
//        solution.insertIntoBST(root,10);
//        solution.isTrueTree(root, new ArrayList<>());
//        solution.getMinimumDifference1(root);
//         int[] nums=new int[]{};
//        TreeNode treeNode = solution.sortedArrayToBST(nums);
//        TreeNode three=new TreeNode(3,null,null);
//        TreeNode five=new TreeNode(5,null,null);
//        solution.lowestCommonAncestor(root,three,five);
        solution.kthSmallest1(root,7);
    }


}
