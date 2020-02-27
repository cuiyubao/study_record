package com.study.concurrence.imooccache;

import com.study.concurrence.imooccache.computable.Computable;

/**
 *  耗时 计算的实现类，实现了Computable接口，但是不具备缓存能力，不需要考虑缓存的事情
 *
 * @author cuiyubao
 * @date 2020/2/26 下午 11:54
 */
public class ExpensiveFunction implements Computable<String,Integer> {
    @Override
    public Integer compute(String arg) throws Exception {
        Thread.sleep(5000);
        return Integer.valueOf(arg );
    }
}
