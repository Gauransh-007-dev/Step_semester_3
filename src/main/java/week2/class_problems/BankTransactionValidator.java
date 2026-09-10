package main.java.week2.class_problems;

public class BankTransactionValidator {
    public static void main(String[] args) {
        System.out.println(validateAndFormat("   hdf03022600042  "));
        System.out.println(validateAndFormat("12F03022600042"));
    }

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed;
    }

    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);
        if (normalized.length() != 14) return "Invalid: wrong length";
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) return "Invalid: body must be digits";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(normalized.substring(0, 3)).append("] DATE: ");
        sb.append(normalized.substring(3, 5)).append("/").append(normalized.substring(5, 7)).append("/").append(normalized.substring(7, 9));
        sb.append(" | SEQ: ").append(normalized.substring(9));
        return sb.toString();
    }
}