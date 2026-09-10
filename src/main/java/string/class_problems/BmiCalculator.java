package main.java.string.class_problems;

public class BmiCalculator {
    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80};
        double[] weights = {70, 90, 75};
        printWellnessReport(heights, weights);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d - Height: %.2f m, Weight: %.0f kg | BMI: %.2f | Status: %s\n",
                    (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }
}