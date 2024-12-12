package lab4.task1.demonstration.fixed;

public class FlexibleDepositAccount extends BasicAccount implements Deposit, Withdrawable {
    private double interest;

    public FlexibleDepositAccount(double balance, double interest) {
        super(balance);
        this.interest = interest;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println("Зняття коштів: " + amount);
            balance -= amount;
        } else {
            System.out.println("Недостатньо коштів на рахунку.");
        }
    }

    @Override
    public void addInterest() {
        balance += balance * interest;
    }
}
