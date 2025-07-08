package com.java.thread.example.sync;

class Counter {
    private static int count = 0;

    public static synchronized void increment() {
        count++;

    }

    public static int getCount() {
        return count;
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {

        // Thread 1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter.increment();
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
        }

        System.out.println("Final count: " + Counter.getCount());
    }
}
