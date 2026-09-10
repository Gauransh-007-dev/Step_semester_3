package main.java.week2.assigment_problems;

public class IsbnValidator {
    public static void main(String[] args) {
        System.out.println(validateAndFormat("  pen2026004251 "));
        System.out.println(validateAndFormat("12N2026004251"));
    }

    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed;
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);
        if (normalized.length() != 13) return "Invalid: wrong length";
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) return "Invalid: publisher code must be 3 letters";
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) return "Invalid: body must be digits";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(normalized.substring(0, 3)).append("] YEAR: ");
        sb.append(normalized.substring(3, 7)).append(" | CATALOG: ").append(normalized.substring(7));
        return sb.toString();
    }
}