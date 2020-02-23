package com.study.concurrence.collections.predecessor;

import java.util.Vector;

/**
 *   演示Vector  主要是看Vector源码
 *
 * @author cuiyubao
 * @date 2020/2/23 下午 10:03
 */
public class VectorDemo {
      public static void main(String[] args){
          Vector<String> vector=new Vector<>();
          vector.add("test");
          System.out.println(vector.get(0));

      }




}
