package fivefun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    private final Object lock = new Object();
    private int currentNumber = 1;

    public void printTwo() {
        synchronized (lock) {
            if (currentNumber % 2 == 0 && currentNumber % 3 != 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
                System.out.println("Number " + currentNumber + " is divisible by 2");
            }
        }
    }

    public void printThree() {
        synchronized (lock) {
            if (currentNumber % 3 == 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
                System.out.println("Number " + currentNumber + " is divisible by 3");
            }
        }
    }

    public void printFour() {
        synchronized (lock) {
            if (currentNumber % 4 == 0 && currentNumber % 5 != 0) {
                System.out.println("Number " + currentNumber + " is divisible by 4");
            }
        }
    }

    public void printFive() {
        synchronized (lock) {
            if (currentNumber % 5 == 0) {
                System.out.println("Number " + currentNumber + " is divisible by 5");
            }
        }
    }

    public void printNumber() {
        synchronized (lock) {
            if (currentNumber % 2 != 0 && currentNumber % 3 != 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
                System.out.println("Number " + currentNumber + " is not divisible by 2, 3, 4, or 5");
            }
        }
    }

    public void startPrinting() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while (currentNumber <= 15) {
            executorService.submit(() -> printTwo());
            executorService.submit(() -> printThree());
            executorService.submit(() -> printFour());
            executorService.submit(() -> printFive());
            executorService.submit(() -> printNumber());
            
            synchronized (lock) {
                currentNumber++;
            }

            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    public static void main(String[] args) {
       main printer = new main();
        printer.startPrinting();
    }
}
