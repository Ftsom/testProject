package com.ldy.threadCase.create;

/**
 * Create by liudongyang8 on 2020/4/3
 * 创建线程-继承Thread
 */
public class ThreadCreateExtend extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadCreateExtend threadCreate = new ThreadCreateExtend();
        threadCreate.start();
    }
}
