package com.study.concurrence.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 描述  演示get方法过程中抛出异常， for循环为了演示抛出异常Exception的时机； 并不是说一产生就抛出异常，直到
 * 我们get执行时，才会抛出
 *
 * @author cuiyubao
 * @date 2020/2/18 下午 08:24
 */
public class GetException {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        Future<Integer> future = service.submit(new CallableTask());

        try {

            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("InterruptedException异常");
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("ExecutionException异常");
        }


    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            throw new IllegalArgumentException("Callable抛出异常");
        }
    }

}
