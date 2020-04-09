package com.ldy.threadCase.use;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Create by liudongyang8 on 2020/4/9
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cycleBarrier = new CyclicBarrier(2, () -> System.out.println("------------last task over--------------"));

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " beginning do");
            try {
                Thread.sleep(2000);
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
                cycleBarrier.await();
                System.out.println(Thread.currentThread().getName() + " do over");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        cycleBarrier.reset();
    }
}
