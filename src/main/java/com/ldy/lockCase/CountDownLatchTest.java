package com.ldy.lockCase;

import java.util.concurrent.CountDownLatch;

/**
 * Create by liudongyang8 on 2020/4/9
 * 闭锁：某一线程等待，其他线程特定操作结束后，继续执行；
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "beginning do");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "beginning do");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end");
            countDownLatch.countDown();
        }).start();

        try {
            System.out.println("--------------main will await-------------");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
