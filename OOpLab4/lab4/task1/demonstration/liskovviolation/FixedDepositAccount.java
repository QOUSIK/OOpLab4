package lab4.task1.demonstration.liskovviolation;

import java.util.Date;

public class FixedDepositAccount extends Account implements Deposit {
    private double interest;
    private Date endDate;

    public FixedDepositAccount(double balance, double interest, Date endDate) {
        super(balance);
        this.interest = interest;
        this.endDate = endDate;
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Зняття коштів недоступне до закінчення терміну депозиту.");
    }

    @Override
    public void addInterest() {
        if (!isDepositOver()) {
            balance += balance * interest;
        } else {
            System.out.println("Депозит закінчився. Відсотки не нараховуються.");
        }
    }

    private boolean isDepositOver() {
        return new Date().after(endDate);
    }
}