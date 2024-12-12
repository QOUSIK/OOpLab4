package lab4.task1.demonstration.liskovviolation;

public class FlexibleDepositAccount extends Account implements Deposit {
    private double interest;

    public FlexibleDepositAccount(double balance, double interest) {
        super(balance);
        this.interest = interest;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }

    @Override
    public void addInterest() {
        balance += balance * interest;
    }

    public double getInterest() {
        return interest;
    }
}
