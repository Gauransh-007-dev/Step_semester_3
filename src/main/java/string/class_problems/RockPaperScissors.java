package main.java.string.class_problems;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();
        
        int wins = 0, losses = 0, draws = 0;
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            String computerMove = moves[random.nextInt(3)];
            String playerMove = playerMoves[i];
            String result = playRound(playerMove, computerMove);
            
            System.out.println("Round " + (i + 1) + " - Player: " + playerMove + ", Computer: " + computerMove + " | " + result);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        
        double winPercentage = ((double) wins / n) * 100;
        System.out.printf("Final Summary | Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}