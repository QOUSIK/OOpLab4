package lab4.task1.demonstration.fixed;

import java.util.Date;

public class FixedDepositAccount extends BasicAccount implements Deposit {
    private double interest;
    private Date endDate;

    public FixedDepositAccount(double balance, double interest, Date endDate) {
        super(balance);
        this.interest = interest;
        this.endDate = endDate;
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