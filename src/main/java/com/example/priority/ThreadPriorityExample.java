package com.example.priority;

class ThreadPriorityExample {

    public static void main(String[] args) {

        // Thread 1 with HIGH priority
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 (HIGH priority) is starting.");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
                }
            }
            System.out.println("Thread 1 (HIGH priority) is finished.");
        });

        // Thread 2 with LOW priority (default priority)
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 (LOW priority) is starting.");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
                }
            }
            System.out.println("Thread 2 (LOW priority) is finished.");
        });

        // Set thread priorities
        thread1.setPriority(Thread.MAX_PRIORITY);  // HIGH priority
        thread2.setPriority(Thread.MIN_PRIORITY);  // LOW priority

        // Start threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
        }
    }
}
