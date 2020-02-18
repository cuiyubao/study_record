package com.study.concurrence.future;

import java.util.concurrent.*;

/**
 * 描述 ： 演示FutureTask的用法
 *
 * @author cuiyubao
 * @date 2020/2/18 下午 10:24
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        Task task = new Task();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        //线程中运行
//        new Thread(integerFutureTask).start();
        //线程池运行
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(integerFutureTask);
        try {
            Integer integer = integerFutureTask.get();
            System.out.println("task运行结果：" + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = sum + i;
        }
        return sum;
    }
}