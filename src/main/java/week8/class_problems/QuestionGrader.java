package main.java.week8.class_problems;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    String correctAnswer, studentAnswer;
    double points;
    Question(String correct, String student, double points) {
        this.correctAnswer = correct; this.studentAnswer = student; this.points = points;
    }
    abstract double evaluate();
}

class ExactMatchQuestion extends Question {
    ExactMatchQuestion(String c, String s, double p) { super(c, s, p); }
    double evaluate() { return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0; }
}

class EssayQuestion extends Question {
    EssayQuestion(String c, String s, double p) { super(c, s, p); }
    double evaluate() {
        String[] keys = correctAnswer.split(",");
        int matches = 0;
        String studentAnsLower = studentAnswer.toLowerCase();
        for (String key : keys) {
            if (studentAnsLower.contains(key.trim().toLowerCase())) matches++;
        }
        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        double totalScore = 0;
        
        Pattern pattern = Pattern.compile("^(\\w+)\\s+\"([^\"]+)\"\\s+\"([^\"]+)\"\\s+\"([^\"]+)\"\\s+(\\d+)$");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                String type = m.group(1);
                String correct = m.group(3);
                String student = m.group(4);
                double pts = Double.parseDouble(m.group(5));
                
                Question q = null;
                if (type.equals("MCQ") || type.equals("TF")) q = new ExactMatchQuestion(correct, student, pts);
                else if (type.equals("ESSAY")) q = new EssayQuestion(correct, student, pts);
                
                if (q != null) {
                    double score = q.evaluate();
                    System.out.printf("%s: %.2f\n", type, score);
                    totalScore += score;
                }
            }
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}