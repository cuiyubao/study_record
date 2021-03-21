package com.study.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author cuiyubao
 * @date 2020/12/19/019 下午 11:27
 */
@Slf4j
class PrintABC {

    //通过JDK5中的锁来保证线程的访问的互斥
    private static Lock lock = new ReentrantLock();
    private static int state = 1;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                System.out.println("ThreadA获取到锁：" + i);
                if (state % 3 == 1) {
                    log.info("state:[{}],state % 3 :[{}]", state, state % 3);
                    System.out.println("1");
                    state++;
                    i++;
                }
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                System.out.println("ThreadB获取到锁：" + i);
                if (state % 3 == 2) {
                    log.info("state:[{}],state % 3 :[{}]", state, state % 3);
                    System.out.println("2");
                    state++;
                    i++;
                }
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                System.out.println("ThreadC获取到锁：" + i);
                if (state % 3 == 0) {
                    log.info("state:[{}],state % 3 :[{}]", state, state % 3);
                    System.out.println("3");
                    state++;
                    i++;
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
        System.out.println("启动完成");

    }


}

