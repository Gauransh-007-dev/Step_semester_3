package main.java.week5.assigment_problems;

public class MatchGridAnalyzer {
    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
    }

    static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            sb.append("Match ").append(i).append(": ");
            
            if (avg >= threshold) {
                sb.append("Power Surge");
            } else {
                sb.append("Normal");
            }
            
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}