package main.java.week8.assigment_problems;
import java.util.Scanner;

abstract class Vehicle {
    int hours;
    Vehicle(int hours) { this.hours = hours; }
    abstract double getCharge();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }
    double getCharge() { return hours * 10.0; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }
    double getCharge() { return hours == 0 ? 0 : 30.0 + ((hours - 1) * 20.0); }
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }
    double getCharge() { return Math.max(100.0, hours * 50.0); }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v = null;
            
            if (type.equals("BIKE")) v = new Bike(hours);
            else if (type.equals("CAR")) v = new Car(hours);
            else if (type.equals("TRUCK")) v = new Truck(hours);
            
            if (v != null) {
                double charge = v.getCharge();
                System.out.printf("%s: %.2f\n", type, charge);
                total += charge;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}