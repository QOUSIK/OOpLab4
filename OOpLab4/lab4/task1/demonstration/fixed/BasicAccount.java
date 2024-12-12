package lab4.task1.demonstration.fixed;

public class BasicAccount implements Account {
    protected double balance;

    public BasicAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}
