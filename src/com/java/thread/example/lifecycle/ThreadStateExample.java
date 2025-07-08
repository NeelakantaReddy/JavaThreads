package com.java.thread.example.lifecycle;

class SharedResource {
    public synchronized void accessResource(String threadName) {
        System.out.println(threadName + " is accessing the resource.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
        }
        System.out.println(threadName + " has finished accessing the resource.");
    }
}

public class ThreadStateExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            resource.accessResource("Thread 1");
        });

        Thread thread2 = new Thread(() -> {
            resource.accessResource("Thread 2");
        });

        System.out.println("Thread 1 State: " + thread1.getState());
        System.out.println("Thread 2 State: " + thread2.getState());

        thread1.start();
        thread2.start();

        try {
            System.out.println("Thread 1 State: " + thread1.getState());
            System.out.println("Thread 2 State: " + thread2.getState());

            Thread.sleep(1000);

            System.out.println("Thread 1 State: " + thread1.getState());
            System.out.println("Thread 2 State: " + thread2.getState());
            
            thread1.join();
            thread2.join();
            
            System.out.println("Thread 1 State after completion: " + thread1.getState());
            System.out.println("Thread 2 State after completion: " + thread2.getState());

        } catch (InterruptedException e) {
            System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
        }
    }
}
