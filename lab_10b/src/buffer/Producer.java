package buffer;


public class Producer implements Runnable {
 private final BoundedBuffer buffer;

 public Producer(BoundedBuffer buffer) {
     this.buffer = buffer;
 }

 @Override
 public void run() {
     int value = 0;
     try {
         while (true) {
             buffer.put(++value);
             Thread.sleep(500);  
         }
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
         System.out.println("Producer was interrupted.");
     }
 }
}
