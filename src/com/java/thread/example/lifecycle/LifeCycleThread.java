package com.java.thread.example.lifecycle;

class ChildThread extends Thread {

    public ChildThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(String.format("%s got interrupted.", getName()));
        }
        System.out.println(String.format("Inside child thread: %s", getState().name()));
    }
}

public class LifeCycleThread {
    public static void main(String[] args) {
        ChildThread childThread = new ChildThread("Child");
        System.out.println(String.format("child thread state: %s", childThread.getState().name()));
        childThread.start();
        try {
            childThread.join();
        } catch (InterruptedException e) {
            System.out.println(String.format("%s got interrupted.", Thread.currentThread().getName()));
        }
        System.out.println(String.format("child thread state: %s", childThread.getState().name()));
        System.out.println(String.format("Thread is running : %s", Thread.currentThread().getName()));

    }
}