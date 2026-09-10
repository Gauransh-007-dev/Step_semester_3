package main.java.week2.assigment_problems;

public class WordReversalEncoder {
    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word).reverse();
            result.append(reversed).append(" ");
        }
        return result.toString().trim();
    }
}