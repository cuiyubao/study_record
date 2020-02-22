package com.study.concurrence.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示多线程预定电影院座位
 *
 * @author cuiyubao
 * @date 2020/2/21 上午 12:34
 */
public class CinemaBookSeat {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   bookSeat();
               }
           }).start();
           new Thread(()->bookSeat()).start();
           new Thread(()->bookSeat()).start();
           new Thread(()->bookSeat()).start();
    }


    private static void bookSeat () {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始预定座位");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"完成预定座位");

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
