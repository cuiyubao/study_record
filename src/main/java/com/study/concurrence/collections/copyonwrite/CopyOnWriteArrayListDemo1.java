package com.study.concurrence.collections.copyonwrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  演示CopyOnWriteArrayList可以在迭代的过程汇总修改数组内容，但ArrayList不行
 *
 * @author cuiyubao
 * @date 2020/2/25 上午 12:16
 */
public class CopyOnWriteArrayListDemo1
{
    public static void main(String[] args){
//        ArrayList<String> list = new ArrayList<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("list is"+list);
            String next=iterator.next();
            System.out.println(next);
            if(next.equals("2")){
                list.remove("5");
            }
            if(next.equals("3")){
                list.add("3 found");
            }
        }

    }
}
