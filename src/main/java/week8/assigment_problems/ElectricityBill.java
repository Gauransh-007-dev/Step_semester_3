package main.java.week8.assigment_problems;
import java.util.Scanner;

abstract class Room {
    int units;
    Room(int units) { this.units = units; }
    abstract double getBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }
    double getBill() { return units * 8.0; }
}

class SharedRoom extends Room {
    int occupants;
    SharedRoom(int units, int occupants) { super(units); this.occupants = occupants; }
    double getBill() { return (units * 6.0) / occupants; }
}

class ACRoom extends Room {
    ACRoom(int units) { super(units); }
    double getBill() { return (units * 10.0) + 200.0; }
}

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r = null;
            
            if (type.equals("SINGLE")) r = new SingleRoom(units);
            else if (type.equals("SHARED")) r = new SharedRoom(units, sc.nextInt());
            else if (type.equals("AC")) r = new ACRoom(units);
            
            if (r != null) {
                double bill = r.getBill();
                System.out.printf("%s: %.2f\n", type, bill);
                total += bill;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}