package fr.saurel.remi;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Board board = new Board();
        Game game = new Game(board, player1);

        do {
            game.start();
            System.out.println("Enter the letters: ");
            // Wait for user input
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            // Check if input is valid (6 letters)
            if (input.length() != 6) {
                System.out.println("You must enter 6 letters");
                continue;
            }
            // Find a word with the 6 letters
            List<String> possibleWordList = Board.findPossibleWordList(input);
            if (possibleWordList.isEmpty()) {
                System.out.println("No words found");
                continue;
            } else {
                System.out.println("Possible words: " + possibleWordList);
            }

            game.end();
        } while (true);
    }
}