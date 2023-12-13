package fr.saurel.remi;

import java.util.HashMap;

public class Board {
    private HashMap<Character, Integer> LETTERS_OCCURENCES = new HashMap<Character, Integer>() {{
        put('a', 10);
        put('b', 2);
        put('c', 3);
        put('d', 4);
        put('e', 17);
        put('f', 2);
        put('g', 3);
        put('h', 3);
        put('i', 9);
        put('j', 2);
        put('k', 1);
        put('l', 6);
        put('m', 3);
        put('n', 7);
        put('o', 7);
        put('p', 3);
        put('q', 2);
        put('r', 6);
        put('s', 7);
        put('t', 7);
        put('u', 6);
        put('v', 3);
        put('w', 1);
        put('x', 1);
        put('y', 1);
        put('z', 1);
        put('J', 2);
        put('B', 1);
    }};

    public Board() {
    }

    public HashMap<Character, Integer> getLettersOccurences() {
        return LETTERS_OCCURENCES;
    }

    public int getLettersOccurences(char letter) {
        return LETTERS_OCCURENCES.get(letter);
    }

    public void setLettersOccurences(char letter, int occurences) {
        LETTERS_OCCURENCES.put(letter, occurences);
    }
}
