package com.example.name;

class ChildThread extends Thread {

    public ChildThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(String.format("%s got interrupted.", Thread.currentThread().getName()));
        }
        System.out.println(String.format("Inside thread: %s",Thread.currentThread().getName()));

    }
}

public class ThreadName {
    public static void main(String[] args) {
        System.out.println(String.format("Inside main thread before name change : %s", Thread.currentThread().getName()));
        ChildThread childThread = new ChildThread("Child");
        childThread.run();
        childThread.setName("CustomChild");
        Thread.currentThread().setName("CustomMain");
        System.out.println(String.format("Inside main thread after name change : %s", Thread.currentThread().getName()));
    }
}