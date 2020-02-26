package com.study.concurrence.collections.copyonwrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  对比两个迭代器
 * @author cuiyubao
 * @date 2020/2/25 上午 09:59
 */
public class CopyOnWriteArrayListDemo2 {
    public static void main(String[] args){

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});
        System.out.println(list);

        Iterator<Integer> itr1 = list.iterator();
        list.add(4);

        Iterator<Integer> itr2 = list.iterator();
        System.out.println(list);

        itr1.forEachRemaining(System.out::println);
        itr2.forEachRemaining(System.out::println);


    }


}
