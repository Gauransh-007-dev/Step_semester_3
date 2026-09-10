package main.java.string.class_problems;

public class ReverseName {
    public static void main(String[] args) {
        String original = "Sunil";
        String reversed = reverseCustomerName(original);
        System.out.println("Original Name: " + original);
        System.out.println("Reversed Name: " + reversed);
    }

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        String result = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }
        return result;
    }
}