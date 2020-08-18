package com.study.DataStructure.tree;

/**
 * @author cuiyubao
 * @date 2020/8/11 下午 06:17
 */
public class TreeMain {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{2, 3, 4, 1, 5};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (Integer datum : data) {
            tree.add(datum);
        }




    }
}
