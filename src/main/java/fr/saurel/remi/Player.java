package fr.saurel.remi;

import java.util.ArrayList;

public class Player {

    private ArrayList<Character> letters = new ArrayList<Character>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Character> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Character> letters) {
        this.letters = letters;
    }

    public void removeLetters(ArrayList<Character> letters) {
        this.letters.removeAll(letters);
    }

    public void addLetters(ArrayList<Character> letters) {
        this.letters.addAll(letters);
    }

    public int getLettersSize() {
        return this.letters.size();
    }
}
