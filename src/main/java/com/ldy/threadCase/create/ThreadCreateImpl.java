package com.ldy.threadCase.create;

/**
 * Create by liudongyang8 on 2020/4/3
 *
 * 创建线程-实现Runnable接口
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
        //创建Thread传入Runnable实现对象
        Thread thread = new Thread(new ThreadCreateImpl());
        //开始线程
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }

}
