package fr.saurel.remi;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Board board = new Board();
        Game game = new Game(board, player1, player2);
    }
}