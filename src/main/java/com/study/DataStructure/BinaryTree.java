package com.study.DataStructure;

import java.util.*;

/**二叉树的遍历
 *  前序递归遍历算法：访问根结点-->递归遍历根结点的左子树-->递归遍历根结点的右子树
 *
 *  中序递归遍历算法：递归遍历根结点的左子树-->访问根结点-->递归遍历根结点的右子树
 *
 *  后序递归遍历算法：递归遍历根结点的左子树-->递归遍历根结点的右子树-->访问根结点
 *
 * User: cuiyubao
 * Date: 2019/4/29
 * Time: 上午 06:41
 */
public class BinaryTree {

    public Node init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
    }

    public void printNode(Node node){
        System.out.print(node.getData());
    }
    //================================    递归实现start       ===========================
    public void theFirstTraversal(Node root) {  //先序遍历
        printNode(root);
        if (root.getLeftNode() != null) {  //使用递归进行遍历左孩子
            theFirstTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) {  //递归遍历右孩子
            theFirstTraversal(root.getRightNode());
        }
    }
    public void theInOrderTraversal(Node root) {  //中序遍历
        if (root.getLeftNode() != null) {
            theInOrderTraversal(root.getLeftNode());
        }
        printNode(root);
        if (root.getRightNode() != null) {
            theInOrderTraversal(root.getRightNode());
        }
    }


    public void thePostOrderTraversal(Node root) {  //后序遍历
        if (root.getLeftNode() != null) {
            thePostOrderTraversal(root.getLeftNode());
        }
        if(root.getRightNode() != null) {
            thePostOrderTraversal(root.getRightNode());
        }
        printNode(root);
    }
    //================================    递归实现end      ===========================

    //================================    栈实现start      ===========================
    /**
     * 非递归先序遍历二叉树
     * */
    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> resultList=new ArrayList<>();
        Stack<Node> treeStack=new Stack<>();
        if(root==null) //如果为空树则返回
            return resultList;
        treeStack.push(root);
        while(!treeStack.isEmpty()){
            Node tempNode=treeStack.pop();
            if(tempNode!=null){
                resultList.add(tempNode.getData());//访问根节点
                treeStack.push(tempNode.getRightNode()); //入栈右孩子
                treeStack.push(tempNode.getLeftNode());//入栈左孩子
            }
        }
        return resultList;
    }

    /**
     * 非递归中序遍历
     * */
    public List<Integer> inorderTraversalNonCur(Node root) {
        List<Integer> visitedList=new ArrayList<>();
        Map<Node,Integer> visitedNodeMap=new HashMap<>();//保存已访问的节点
        Stack<Node> toBeVisitedNodes=new Stack<>();//待访问的节点
        if(root==null)
            return visitedList;
        toBeVisitedNodes.push(root);
        while(!toBeVisitedNodes.isEmpty()){
            Node tempNode=toBeVisitedNodes.peek(); //注意这里是peek而不是pop
            while(tempNode.getLeftNode()!=null){ //如果该节点的左节点还未被访问，则需先访问其左节点
                if(visitedNodeMap.get(tempNode.getLeftNode())!=null) //该节点已经被访问（不存在某个节点已被访问但其左节点还未被访问的情况）
                    break;
                toBeVisitedNodes.push(tempNode.getLeftNode());
                tempNode=tempNode.getLeftNode();
            }
            tempNode=toBeVisitedNodes.pop();//访问节点
            visitedList.add(tempNode.getData());
            visitedNodeMap.put(tempNode, 1);//将节点加入已访问map
            if(tempNode.getRightNode()!=null) //将右结点入栈
                toBeVisitedNodes.push(tempNode.getRightNode());
        }
        return visitedList;
    }

    /**
     * 非递归后序遍历
     * */
    public List<Integer> postOrderNonCur(Node root){
        List<Integer> resultList=new ArrayList<>();
        if(root==null)
            return resultList;
        Map<Node,Integer> visitedMap=new HashMap<>();
        Stack<Node> toBeVisitedStack=new Stack<>();
        toBeVisitedStack.push(root);
        while(!toBeVisitedStack.isEmpty()){
            Node tempNode=toBeVisitedStack.peek(); //注意这里是peek而不是pop
            if(tempNode.getLeftNode()==null && tempNode.getRightNode()==null){ //如果没有左右孩子则访问
                resultList.add(tempNode.getData());
                visitedMap.put(tempNode, 1);
                toBeVisitedStack.pop();
                continue;
            }else if(!((tempNode.getLeftNode()!=null&&visitedMap.get(tempNode.getLeftNode())==null )|| (tempNode.getRightNode()!=null && visitedMap.get(tempNode.getRightNode())==null))){
                //如果节点的左右孩子均已被访问            
                resultList.add(tempNode.getData());
                toBeVisitedStack.pop();
                visitedMap.put(tempNode, 1);
                continue;
            }
            if(tempNode.getLeftNode()!=null){
                while(tempNode.getLeftNode()!=null && visitedMap.get(tempNode.getLeftNode())==null){//左孩子没有被访问
                    toBeVisitedStack.push(tempNode.getLeftNode());
                    tempNode=tempNode.getLeftNode();
                }
            }
            if(tempNode.getRightNode()!=null){
                if(visitedMap.get(tempNode.getRightNode())==null){//右孩子没有被访问
                    toBeVisitedStack.push(tempNode.getRightNode());
                }
            }
        }
        return resultList;
    }


//================================    栈实现end     ===========================

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.init();
        System.out.println("先序遍历");
        tree.theFirstTraversal(root);
        System.out.println("");
//        System.out.println("中序遍历");
//        tree.theInOrderTraversal(root);
//        System.out.println("");
//        System.out.println("后序遍历");
//        tree.thePostOrderTraversal(root);
//        System.out.println("");
       System.out.println(preorderTraversal(root));
    }
}