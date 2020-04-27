package com.ldy.lockCase;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by liudongyang8 on 2020/4/17
 */
public class LockTest {
    //lock
    private static int k = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            for (; k <= 10; ) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " : " + k);
                    k++;
                    condition.signal();
                    Thread.sleep(2000);
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
