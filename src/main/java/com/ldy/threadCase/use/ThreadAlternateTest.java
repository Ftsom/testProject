package com.ldy.threadCase.use;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by liudongyang8 on 2020/4/3
 * 线程交易打印奇偶数：加锁方式 、cas自旋方式
 */
public class ThreadAlternateTest {
    //synchronized
    private static int i = 1;
    private static final ThreadAlternateTest threadAlternateTest = new ThreadAlternateTest();

    //volatile
    private static volatile int j = 1;
    private static volatile boolean controlFlag = true;

    //lock
    private static int k = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        //synchronized
//        new Thread(() -> {
//            for (; i <= 10; ) {
//                synchronized (threadAlternateTest) {
//                    System.out.println(Thread.currentThread().getName() + " : " + i);
//                    i++;
//                    try {
//                        threadAlternateTest.notify();
//                        threadAlternateTest.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            for (; i <= 10; ) {
//                synchronized (threadAlternateTest) {
//                    System.out.println(Thread.currentThread().getName() + " : " + i);
//                    i++;
//                    try {
//                        threadAlternateTest.notify();
//                        threadAlternateTest.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        //volatile
//        new Thread(() -> {
//            for (; j <= 10; ) {
//                while (controlFlag) {
//                    System.out.println(Thread.currentThread().getName() + " : " + j);
//                    j++;
//                    controlFlag = false;
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            for (; j <= 10; ) {
//                while (!controlFlag) {
//                    System.out.println(Thread.currentThread().getName() + " : " + j);
//                    j++;
//                    controlFlag = true;
//                }
//            }
//        }).start();

        //lock
        new Thread(() -> {
            for (; k <= 10; ) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " : " + k);
                    k++;
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            for (; k <= 10; ) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " : " + k);
                    k++;
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
