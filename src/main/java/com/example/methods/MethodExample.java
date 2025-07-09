package com.example.methods;

class MethodExample {

    public static void main(String[] args) throws InterruptedException {

        // Thread 1
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Thread 1 is starting.");
                Thread.sleep(2000);  // Simulate some work
                System.out.println("Thread 1 is finished.");
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread 2 is starting.");
                Thread.sleep(1000);  // Simulate some work
                System.out.println("Thread 2 is finished.");
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
            }
        });

        // Start threads
        thread1.start();
        thread2.start();

        thread1.interrupt();
        // Main thread waits for thread1 and thread2 to finish
        thread1.join();  // Wait for thread1 to finish
        thread2.join();  // Wait for thread2 to finish

        // After both threads finish, main thread resumes
        System.out.println("Main thread is finished.");
    }
}
