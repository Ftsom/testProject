package com.ldy.threadTest.create;

/**
 * Create by liudongyang8 on 2020/4/3
 */
public class ThreadCreateImpl implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadCreateImpl());
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }

}
