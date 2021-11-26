package com.study.temp;

import java.util.PriorityQueue;

/**
 * @Author cuiyubao
 * @Date 2021/11/26 10:34 上午
 */
public class PriorityTest {


    public static void main(String[] args) {
        testPriority();
    }


    public static void testPriority(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(9);
        System.out.println(queue);
        for (int i = queue.size() - 1; i >= 0; i--) {
            System.out.println(queue.poll());
        }

//
//        PriorityQueue<String> queue1 = new PriorityQueue<>();
//        queue1.add("apple");
//        queue1.add("pear");
//        queue1.add("banana");
//        queue1.add("aa");
//        System.out.println(queue1);
    }
}
