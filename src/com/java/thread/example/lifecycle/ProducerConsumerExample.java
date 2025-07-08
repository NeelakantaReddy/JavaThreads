package com.java.thread.example.lifecycle;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 10;

    // Producer method
    public synchronized void produce() throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer full, producer is waiting...");
            wait();
        }
        buffer.offer(1);
        System.out.println("Produced 1 item. Buffer size: " + buffer.size());
        notify();
    }

    // Consumer method
    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty, consumer is waiting...");
            wait();
        }
        buffer.poll();
        System.out.println("Consumed 1 item. Buffer size: " + buffer.size());
        notify();
    }

    public Queue<Integer> getBuffer() {
        return buffer;
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    sharedBuffer.produce();
                    Thread.sleep(10);
                    if(sharedBuffer.getBuffer().size() == 10){
                        break;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    sharedBuffer.consume();
                    Thread.sleep(20);
                    if(sharedBuffer.getBuffer().size() == 0){
                        break;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread '%s' got interrupted", Thread.currentThread().getName()));
            }
        });

        producer.start();
        consumer.start();
    }
}
