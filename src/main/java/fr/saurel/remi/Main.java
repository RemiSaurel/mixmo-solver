package fr.saurel.remi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int nbPlayers = scanner.nextInt();

        // Create players
        Player[] players = new Player[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name: ");
            String name = scanner.next();
            players[i] = new Player(name);
        }

        // Create game
        Game game = new Game(board, players);
        game.setPlayers(new ArrayList<>(Arrays.asList(players)));
        game.start();
        do {
            for (Player player : game.getPlayers()) {
                System.out.println(player.getName() + " turn:");
                // Wait for user input
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();

                // Check if input is valid
                if (game.isInputInvalid(input)) {
                    System.out.println("You must enter " + (game.isFirstTurn() ? "6" : "2") + " letters");
                    continue;
                }

                ArrayList<Character> letters = new ArrayList<>();
                for (char c : input.toCharArray()) {
                    letters.add(c);
                }

                player.addLetters(letters);

                // Find a word with the 6 letters
                List<String> possibleWordList = Board.findPossibleWordList(player.getLetters());
                if (possibleWordList.isEmpty()) {
                    System.out.println("No words found");
                } else {
                    System.out.println("Possible words: " + possibleWordList);
                }
            }

            // Set the first turn to false after first turn
            game.setFirstTurn(false);
        } while (true);
    }
}