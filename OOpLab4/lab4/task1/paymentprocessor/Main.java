package lab4.task1.paymentprocessor;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        Customer regularCustomer = new RegularCustomer();
        Customer premiumCustomer = new PremiumCustomer();

        double regularDiscount = paymentProcessor.calculateDiscount(regularCustomer, 1000);
        double premiumDiscount = paymentProcessor.calculateDiscount(premiumCustomer, 1000);

        System.out.println("Regular Customer Discount: " + regularDiscount);
        System.out.println("Premium Customer Discount: " + premiumDiscount);
    }
}

interface Customer {
    double getDiscountRate();
}

class RegularCustomer implements Customer {
    @Override
    public double getDiscountRate() {
        return 0.05;
    }
}

class PremiumCustomer implements Customer {
    @Override
    public double getDiscountRate() {
        return 0.10;
    }
}

class PaymentProcessor {
    public double calculateDiscount(Customer customer, double amount) {
        return amount * customer.getDiscountRate();
    }
}

