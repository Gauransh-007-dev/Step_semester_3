package main.java.week8.assigment_problems;
import java.util.Scanner;

abstract class Customer {
    double billAmount;
    Customer(double billAmount) { this.billAmount = billAmount; }
    abstract double getFinalAmount();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) { super(amount); }
    double getFinalAmount() { return billAmount * 0.90; }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) { super(amount); }
    double getFinalAmount() { return billAmount * 0.95; }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) { super(amount); }
    double getFinalAmount() { return billAmount + 10; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer c = null;
            
            if (type.equals("STUDENT")) c = new StudentCustomer(amount);
            else if (type.equals("STAFF")) c = new StaffCustomer(amount);
            else if (type.equals("GUEST")) c = new GuestCustomer(amount);
            
            if (c != null) {
                double finalAmount = c.getFinalAmount();
                System.out.printf("%s: %.2f\n", type, finalAmount);
                total += finalAmount;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}