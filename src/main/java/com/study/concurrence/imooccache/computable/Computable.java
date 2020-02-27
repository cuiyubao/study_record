package com.study.concurrence.imooccache.computable;

/**
 * 描述 有一个计算函数 computer 用来计算耗时计算，每个计算器都实现这个接口，这样就可以无侵入实现缓存功能
 *
 * @author cuiyubao
 * @date 2020/2/26 下午 11:52
 */
public interface Computable<A, V> {
    V compute(A arg) throws Exception;


}
