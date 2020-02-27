package com.study.concurrence.imooccache;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * 描述 最简单的缓存形式  HashMap
 *
 * @author cuiyubao
 * @date 2020/2/26 下午 11:07
 */
public class ImoocCache1 {
    private final HashMap<String, Integer> cache = new HashMap<String, Integer>();

    public Integer computer(String userId) throws InterruptedException {
        Integer result = cache.get(userId);
        //先检查HashMap中有没有保存之前的计算结果
        if (result == null) {
            //如果缓存中找不到，那么需要现在计算一下结果，并保存到HashMap
            result = doComputer(userId);
            cache.put(userId, result);
        }
        return result;
    }

    private Integer doComputer(String userId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return new Integer(userId);
    }

    public static void main(String[] args){

        ImoocCache1 imoocCache1 = new ImoocCache1();

    }


}
