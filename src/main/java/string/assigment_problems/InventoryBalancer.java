package main.java.string.assigment_problems;

public class InventoryBalancer {
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0, sumB = 0;
        int maxQty = -1;
        String maxSection = "";
        int maxIndex = -1;
        
        for (int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }
        }
        
        for (int i = 0; i < sectionB.length; i++) {
            sumB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }
        
        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                sumA, sumB, status, maxQty, maxSection, maxIndex + 1);
    }
}