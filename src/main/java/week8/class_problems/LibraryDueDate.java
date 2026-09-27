package main.java.week8.class_problems;
import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    String title;
    LibraryItem(String title) { this.title = title; }
    abstract LocalDate calculateDueDate(LocalDate borrowDate);
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    LocalDate calculateDueDate(LocalDate borrowDate) { return borrowDate.plusDays(14); }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    LocalDate calculateDueDate(LocalDate borrowDate) { return borrowDate.plusDays(7); }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    LocalDate calculateDueDate(LocalDate borrowDate) { return borrowDate.plusDays(3); }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");
            
            LibraryItem item = null;
            if (type.equals("BOOK")) item = new Book(title);
            else if (type.equals("DVD")) item = new DVD(title);
            else if (type.equals("MAGAZINE")) item = new Magazine(title);
            
            if (item != null) {
                System.out.println(title + ": " + item.calculateDueDate(currentDate));
            }
        }
    }
}