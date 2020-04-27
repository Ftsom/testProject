package com.ldy.lockCase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Create by liudongyang8 on 2020/4/27
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(512);
        Producer producer = new Producer(queue);
        new Thread(producer).start();
        Consumer consumer1 = new Consumer(queue);
        new Thread(consumer1).start();
        Consumer consumer2 = new Consumer(queue);
        new Thread(consumer2).start();
        System.out.println();
    }
}

class Producer implements Runnable {
    BlockingQueue queue;

    @Override
    public void run() {
        while (true) {
            try {
                queue.put(produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Producer(BlockingQueue q) {
        this.queue = q;
    }

    Object produce() {
        Object o = new Object();
        System.out.println("producer is produce " + " " + o.hashCode());
        return o;
    }
}

class Consumer implements Runnable {
    BlockingQueue queue;

    @Override
    public void run() {
        while (true) {
            try {
                consume(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Consumer(BlockingQueue q) {
        this.queue = q;
    }

    void consume(Object o) {
        System.out.println("consumer is consume " + " " + o.hashCode());
    }
}
