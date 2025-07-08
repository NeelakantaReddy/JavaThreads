package com.java.thread.example.runnable;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("In run method: " + Thread.currentThread().getName());
    }

}

public class RunnableThread {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "Child");
        thread.start();
        Thread.currentThread().setName("CustomMain");
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}
