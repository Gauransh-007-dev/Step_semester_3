package main.java.week6.assigment_problems;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: Negative basic salary. Starting at 0.");
        } else {
            this.basicSalary = openingBasicSalary;
        }
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: Amount must be greater than 0");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: Percent must be between 0 and 100");
        } else {
            System.out.println("Tax % deducted: " + percent);
            basicSalary -= (basicSalary * (percent / 100));
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class PayrollSalaryManagement {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}