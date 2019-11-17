package com.study.thread;

/**
 * volatile可见性测试
 *
 * @author cuiyubao
 * @date 2019/11/15 下午 02:28
 */
public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " coming...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addOne();
            System.out.println(Thread.currentThread().getName() + " updated...");
        }).start();

        while (data.a == 0) {

            System.out.println("data.a=" + data.a);
//            Thread.sleep(1000);
        }
        System.out.println("data.a=" + data.a);
        System.out.println(Thread.currentThread().getName() + " job is done...");
    }
}

class Data {
     int a = 0;
//    volatile int a = 0;

    void addOne() {
        this.a += 1;
    }
}











