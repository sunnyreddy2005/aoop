package bank;

class BankAccount {
    private double balance;

  
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ". Current balance: " + balance);
        }
    }

   
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ". Current balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance. Current balance: " + balance);
        }
    }

    
    public double getBalance() {
        return balance;
    }
}
