package com.study.concurrence.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cuiyubao
 * @date 2020/5/19 下午 07:18
 */
public class BarrierTest {

    public static void main(String[] args) {

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("等裁判吹口哨...");
                    //这里停顿两秒更便于观察线程执行的先后顺序
                    Thread.sleep(2000);
                    System.out.println("裁判吹口哨->>>>>");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Runner runner1 = new Runner(cyclicBarrier, "jack");
        Runner runner2 = new Runner(cyclicBarrier, "jade");
        Runner runner3 = new Runner(cyclicBarrier, "duan");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(runner1);
        executorService.submit(runner2);
        executorService.submit(runner3);

        executorService.shutdown();
    }


}

class Runner implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;

    public Runner(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(name + ":准备OK");
            cyclicBarrier.await();
            System.out.println(name + ":开跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}