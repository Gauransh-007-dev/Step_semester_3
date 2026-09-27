package main.java.week8.assigment_problems;
import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    String name;
    LocalDate startDate;
    Subscription(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    abstract LocalDate getRenewalDate();
}

class BasicPlan extends Subscription {
    BasicPlan(String name, LocalDate date) { super(name, date); }
    LocalDate getRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends Subscription {
    StandardPlan(String name, LocalDate date) { super(name, date); }
    LocalDate getRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends Subscription {
    PremiumPlan(String name, LocalDate date) { super(name, date); }
    LocalDate getRenewalDate() { return startDate.plusDays(365); }
}

public class PlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Subscription sub = null;
            
            if (type.equals("BASIC")) sub = new BasicPlan(name, date);
            else if (type.equals("STANDARD")) sub = new StandardPlan(name, date);
            else if (type.equals("PREMIUM")) sub = new PremiumPlan(name, date);
            
            if (sub != null) {
                System.out.println(name + ": " + sub.getRenewalDate());
            }
        }
    }
}