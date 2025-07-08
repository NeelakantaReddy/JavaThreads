package com.java.thread.example;

class ChildThread extends Thread {

    @Override
    public void run() {
        System.out.println("In run method: " + Thread.currentThread().getName());
    }
}

public class FirstThread {
    public static void main(String[] args) {
        ChildThread thread = new ChildThread();
        thread.run();
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}