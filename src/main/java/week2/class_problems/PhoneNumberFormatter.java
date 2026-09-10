package main.java.week2.class_problems;

public class PhoneNumberFormatter {
    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }

    public static String maskPhoneNumber(String phone) {
        if (phone.length() == 10 && phone.matches("\\d+")) {
            StringBuilder masked = new StringBuilder("XXXXXX");
            masked.append("-").append(phone.substring(6));
            return masked.toString();
        }
        return "Invalid phone number";
    }
}