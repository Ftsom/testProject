package com.ldy.threadCase.create;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by liudongyang8 on 2020/4/9
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0;;) {
//            list.add(String.valueOf(i));
//        }
        Executor executor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
        executor.execute(() -> {
            System.out.println("thread pool do");
        });
    }
}
