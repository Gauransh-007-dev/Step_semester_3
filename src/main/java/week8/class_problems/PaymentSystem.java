package main.java.week8.class_problems;
import java.util.Scanner;

abstract class Payment {
    double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }
    double calculateFinalAmount() { return amount + (amount * 0.02); }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super(amount); }
    double calculateFinalAmount() { return amount + (amount * 0.01); }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) { super(amount); }
    double calculateFinalAmount() { return amount; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        sc.close();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment = null;
            
            if (type.equals("CARD")) payment = new CardPayment(amount);
            else if (type.equals("WALLET")) payment = new WalletPayment(amount);
            else if (type.equals("BANKTRANSFER")) payment = new BankTransfer(amount);
            
            if (payment != null) {
                double finalAmount = payment.calculateFinalAmount();
                System.out.printf("%s: %.2f\n", type, finalAmount);
                total += finalAmount;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}