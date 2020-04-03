package com.ldy.threadTest.use;

/**
 * Create by liudongyang8 on 2020/4/3
 * 线程阻塞状态：sleep() / wait() / join() / IO阻塞 / synchronized
 */
public class ThreadBlockTest implements Runnable {
    @Override
    public void run() {
        System.out.println("child thread is interrupt: " + Thread.currentThread().isInterrupted());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        LockSupport.park();
        System.out.println("child thread is interrupt: " + Thread.currentThread().isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadBlockTest());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println(Thread.currentThread().getName());
    }
}
