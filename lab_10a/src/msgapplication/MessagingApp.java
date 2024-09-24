package msgapplication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class SharedBuffer {
    private BlockingQueue<String> buffer = new LinkedBlockingQueue<>(5);  
    
    public void putMessage(String message) throws InterruptedException {
        buffer.put(message); 
        System.out.println("Produced: " + message);
    }

    
    public String takeMessage() throws InterruptedException {
        String message = buffer.take(); 
        System.out.println("Consumed: " + message);
        return message;
    }
}


class Producer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Producer(SharedBuffer buffer) {
        this.sharedBuffer = buffer;
    }

    @Override
    public void run() {
        int messageCount = 1;
        try {
            while (true) {
                String message = "Message " + messageCount;
                sharedBuffer.putMessage(message);
                messageCount++;
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer was interrupted.");
        }
    }
}


class Consumer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer buffer) {
        this.sharedBuffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedBuffer.takeMessage();
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer was interrupted.");
        }
    }
}


public class MessagingApp {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        
        producerThread.start();
        consumerThread.start();
    }
}

