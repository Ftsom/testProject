package com.ldy.threadCase.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Create by liudongyang8 on 2020/4/3
 * callable线程：实现Callable接口，重写call方法
 * 1.可抛出异常
 * 2.futureTask.get()会阻塞主线程
 *
 */
public class ThreadCallable implements Callable<Long> {

    @Override
    public Long call() throws InterruptedException {
        Thread.sleep(2000);
        return Thread.currentThread().getId();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallable threadCallable = new ThreadCallable();
        //创建Task
        FutureTask<Long> futureTask = new FutureTask<>(threadCallable);
        //开始线程
        new Thread(futureTask).start();
        //阻塞获取线程结果
        System.out.println(futureTask.get());
        System.out.println(Thread.currentThread().getName());
    }
}
