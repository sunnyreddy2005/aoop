package bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) {
       
        BankAccount account = new BankAccount(1000);

        
        ExecutorService executorService = Executors.newFixedThreadPool(5);

       
        executorService.submit(new UserTransaction(account, true, 200));  // User deposits 200
        executorService.submit(new UserTransaction(account, false, 500)); // User withdraws 500
        executorService.submit(new UserTransaction(account, true, 100));  // User deposits 100
        executorService.submit(new UserTransaction(account, false, 300)); // User withdraws 300
        executorService.submit(new UserTransaction(account, false, 1000)); // User tries to withdraw 1000

        
        executorService.shutdown();
    }
}
