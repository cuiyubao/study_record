package com.study.concurrence;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch使用
 * 一个线程等待多个线程都执行完毕，再继续自己的工作
 *
 * 工厂中质检  5个工人检查所有人认为通过，才通过
 * @author cuiyubao
 * @date 2020/2/17 下午 10:18
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no=i+1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + no + "完成了检查。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            };
            service.submit(runnable);
        }
       System.out.println("等待5个人检查完");
        latch.await();
        System.out.println("所有人都完成了工作");
    }


}
