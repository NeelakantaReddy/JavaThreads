package com.example.lifecycle;

class WaitNotifyExample {

    private static final Object lock = new Object();  // Lock object for synchronization
    private static final Object lock2 = new Object();  // Lock object for synchronization

    public static void main(String[] args) throws InterruptedException {
        
        // Thread 1: Will wait for a signal to proceed
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiting thread is waiting...");
                    lock.wait();  // This thread will wait until notified
                    System.out.println("Waiting thread has been notified and resumed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        waitingThread.start();

        Thread.sleep(1000);
        System.out.println("Thread state after sleep: " + waitingThread.getState().name());
        // Thread 2: Will notify the waiting thread to continue
        Thread notifyingThread = new Thread(() -> {
            try {
                Thread.sleep(2000);  // Simulate some work before notifying
                synchronized (lock2) {
                    System.out.println("Notifying thread is notifying the waiting thread...");
                    lock2.wait();  // This will notify the waiting thread
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both threads

        notifyingThread.start();

        // Wait for threads to complete
        waitingThread.join();
        notifyingThread.join();
    }
}
