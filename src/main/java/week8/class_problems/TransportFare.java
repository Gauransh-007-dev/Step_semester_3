package main.java.week8.class_problems;
import java.util.Scanner;

abstract class Transport {
    double distance;
    Transport(double distance) { this.distance = distance; }
    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) { super(distance); }
    double calculateFare() { return Math.min(10.0, 2.0 + (0.10 * distance)); }
}

class Train extends Transport {
    Train(double distance) { super(distance); }
    double calculateFare() { return 3.0 + (0.15 * distance); }
}

class Metro extends Transport {
    double peakFactor;
    Metro(double distance, double peakFactor) { super(distance); this.peakFactor = peakFactor; }
    double calculateFare() { return (1.50 + (0.20 * distance)) * peakFactor; }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t = null;
            
            if (type.equals("BUS")) t = new Bus(distance);
            else if (type.equals("TRAIN")) t = new Train(distance);
            else if (type.equals("METRO")) t = new Metro(distance, sc.nextDouble());
            
            if (t != null) {
                double fare = t.calculateFare();
                System.out.printf("%s: %.2f\n", type, fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}