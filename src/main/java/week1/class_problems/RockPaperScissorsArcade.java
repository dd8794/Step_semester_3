package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsArcade {

    // Determines the winner of one round.
    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    // Generates Rock, Paper, or Scissors randomly.
    static String getComputerMove(Random random) {

        String[] moves = {"Rock", "Paper", "Scissors"};

        return moves[random.nextInt(moves.length)];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int rounds = 5;

        String[][] results = new String[rounds][4];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Rock-Paper-Scissors Arcade ===");
        System.out.println("Enter Rock, Paper, or Scissors.");
        System.out.println();

        for (int i = 0; i < rounds; i++) {

            String playerMove;

            while (true) {

                System.out.print("Round " + (i + 1) + " - Your move: ");
                playerMove = scanner.nextLine().trim();

                if (playerMove.equalsIgnoreCase("rock")) {
                    playerMove = "Rock";
                    break;
                } else if (playerMove.equalsIgnoreCase("paper")) {
                    playerMove = "Paper";
                    break;
                } else if (playerMove.equalsIgnoreCase("scissors")) {
                    playerMove = "Scissors";
                    break;
                } else {
                    System.out.println("Invalid move. Enter Rock, Paper, or Scissors.");
                }
            }

            String computerMove = getComputerMove(random);

            String result = playRound(playerMove, computerMove);

            results[i][0] = String.valueOf(i + 1);
            results[i][1] = playerMove;
            results[i][2] = computerMove;
            results[i][3] = result;

            System.out.println("Computer move: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("========== FINAL SUMMARY ==========");
        System.out.printf("%-8s %-15s %-17s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8s %-15s %-17s %-15s%n",
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    results[i][3]);
        }

        System.out.println();
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        scanner.close();
    }
}
