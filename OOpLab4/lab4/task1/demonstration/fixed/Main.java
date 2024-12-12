package lab4.task1.demonstration.fixed;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BasicAccount account = new FlexibleDepositAccount(1000.0, 0.05);
        account.deposit(500); // Операція успішна
        System.out.println("Баланс: " + account.getBalance());
        withdraw(account, 200); // Операція успішна
        System.out.println("Баланс: " + account.getBalance());


        account = new FixedDepositAccount(1000.0, 0.05, new Date(System.currentTimeMillis() + 86400000)); // Депозит на 1 день
        account.deposit(500); // Операція успішна
        System.out.println("Баланс: " + account.getBalance());

        withdraw(account, 200); // Операція успішна
        // помилок немає
        System.out.println("Баланс: " + account.getBalance());
    }

    private static void withdraw(BasicAccount account, double amount) {
        if(account instanceof Withdrawable) {
            ((Withdrawable) account).withdraw(amount); // Операція успішна
        } else{
            System.out.println("Рахунок не підтримує зняття коштів.");
        }
    }
}