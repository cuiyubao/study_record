package com.study.concurrence.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author cuiyubao
 * @date 2020/2/21 上午 12:56
 */
public class GetHoldCount {
    private static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());


    }

}
