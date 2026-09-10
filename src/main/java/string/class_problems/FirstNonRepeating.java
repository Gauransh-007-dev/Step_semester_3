package main.java.string.class_problems;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String text = "swiss";
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            freq[c]++;
        }
        for (char c : text.toCharArray()) {
            if (freq[c] == 1) {
                return c;
            }
        }
        return '\0';
    }
}