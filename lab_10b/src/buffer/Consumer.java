package buffer;


public class Consumer implements Runnable {
 private final BoundedBuffer buffer;

 public Consumer(BoundedBuffer buffer) {
     this.buffer = buffer;
 }

 @Override
 public void run() {
     try {
         while (true) {
             buffer.take();
             Thread.sleep(1000);  
         }
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
         System.out.println("Consumer was interrupted.");
     }
 }
}
