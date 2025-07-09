package com.example.volatilex;

public class WithoutVolatile {
    private volatile static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: Simulate some work and change flag
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
                setFlag(true);  // Use synchronized method to change the flag
                System.out.println("Flag set to true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread 2: Check flag in a loop
        Thread readerThread = new Thread(() -> {
            while (!getFlag()) {
                // Keep checking flag until it becomes true
            }
            System.out.println("Flag is true, reader thread stopping");
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }

    // Synchronized method to change the flag value
    private synchronized static void setFlag(boolean value) {
        flag = value;
    }

    // Synchronized method to read the flag value
    private synchronized static boolean getFlag() {
        return flag;
    }
}
