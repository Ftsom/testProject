package com.ldy.threadCase.use;

/**
 * Create by liudongyang8 on 2020/4/3
 * join() 调用线程执行完毕后，在去执行包含线程
 */
public class ThreadJoinTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is start !");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "is over !");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadJoinTest(), "Thread1");
        thread1.start();
        thread1.join();

        System.out.println(Thread.currentThread().getName());
    }
}
