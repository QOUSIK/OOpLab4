package lab4.task1.demonstration.liskovviolation;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Account account = new FlexibleDepositAccount(1000, 0.05);
        account.deposit(500); // Операція успішна
        System.out.println("Баланс: " + account.getBalance());
        account.withdraw(200); // Операція успішна
        System.out.println("Баланс: " + account.getBalance());


        account = new FixedDepositAccount(1000, 0.05, new Date(System.currentTimeMillis() + 86400000)); // Депозит на 1 день
        account.deposit(500); // Операція успішна
        System.out.println("Баланс: " + account.getBalance());

        try {
            account.withdraw(200); // Кидає UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println("Баланс: " + account.getBalance());
    }
}