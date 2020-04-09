package com.ldy.threadCase.use;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * Create by liudongyang8 on 2020/4/9
 */
public class SemaphoreTest {
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> semaphoreTest.doThing()).start();
        }
    }

    private void doThing() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "-start : " + getFormatTimeStr());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "-end : " + getFormatTimeStr());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getFormatTimeStr() {
        return sf.format(new Date());
    }
}
