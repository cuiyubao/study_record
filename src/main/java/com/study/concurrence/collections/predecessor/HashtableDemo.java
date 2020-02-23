package com.study.concurrence.collections.predecessor;

import java.util.Hashtable;

/**
 * @author cuiyubao
 * @date 2020/2/23 下午 10:26
 */
public class HashtableDemo {
    public static void main(String[] args){

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("学完以后跳槽涨薪幅度","50%");
        System.out.println(hashtable.get("学完以后跳槽涨薪幅度"));
    }

}
