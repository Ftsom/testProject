package com.ldy.lockCase;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Create by liudongyang8 on 2020/4/9
 * 栅栏：阻塞一组线程直到某个事件的发生。一组线程共同到达一个栅栏后，继续执行；
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cycleBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " beginning do");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep end");
                cycleBarrier.await();
                System.out.println(Thread.currentThread().getName() + " do over");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " beginning do");
            try {
                cycleBarrier.await(5L, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + " do over");
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                e.printStackTrace();
            }
        }).start();
//        cycleBarrier.reset();
    }
}
