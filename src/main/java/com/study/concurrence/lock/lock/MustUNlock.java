package com.study.concurrence.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述 Lock不会像synchronized一样，异常的时候回释放锁，所以最佳实践，finally中释放锁，以便保证发生异常的时候锁一定被释放
 *
 * @author cuiyubao
 * @date 2020/2/20 下午 10:54
 */
public class MustUNlock {

    private static Lock lock=new ReentrantLock();

    public static void main(String[] args){
      lock.lock();
      try{
          //获取本锁保护的资源
          System.out.println(Thread.currentThread().getName()+"开始执行任务");
      }finally {
          lock.unlock();
      }

    }

}
