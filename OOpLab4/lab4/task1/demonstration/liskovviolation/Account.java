package lab4.task1.demonstration.liskovviolation;

public class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println("Зняття коштів: " + amount);
            balance -= amount;
        } else {
            System.out.println("Недостатньо коштів на рахунку.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
