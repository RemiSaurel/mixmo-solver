package fr.saurel.remi;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private Board board;

    public Game(Board board, Player... players) {
        this.players.addAll(Arrays.asList(players));
        this.board = board;
    }

    public void start() {
        System.out.println("Game started");
    }

    public void end() {
        System.out.println("Game ended");
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
