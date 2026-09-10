package main.java.week5.class_problems;

public class SeatingGridOptimizer {
    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
    }

    static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            result.append("Row ").append(i).append(": ");
            if (avg >= threshold) {
                result.append("Buzzing Zone");
            } else {
                result.append("Quiet Zone");
            }
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }
}