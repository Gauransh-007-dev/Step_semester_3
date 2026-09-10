package main.java.week2.class_problems;

public class FileExtensionValidator {
    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }

    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex > 0) {
            String extension = filename.substring(dotIndex + 1);
            if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("zip")) {
                return "Accepted";
            }
        }
        return "Rejected - invalid file type";
    }
}