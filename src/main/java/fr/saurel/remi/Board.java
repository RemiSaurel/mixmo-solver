package fr.saurel.remi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    /**
     * Find the words that can be created with the input letters
     * @param input The input letters
     * @return A list of words that can be created with the input letters, or an empty list if no words were found
     */
    public static List<String> findPossibleWordList(String input) {
        List<String> possibleWordList = new ArrayList<>();

        // Use a HashSet for constant-time lookups
        Set<Character> inputLetters = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputLetters.add(c);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.txt"))) {
            // Read all lines at once for efficiency
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Sort the words based on the number of letters used
            lines.sort(Comparator.comparingInt(word -> countUsedLetters(inputLetters, word)));

            // Find words that can be created with the input letters
            for (String word : lines) {
                if (canCreateWord(inputLetters, word)) {
                    possibleWordList.add(word);
                    // Remove letters from the input letters so they can't be used twice
                    for (char c : word.toCharArray()) {
                        inputLetters.remove(c);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return possibleWordList;
    }

    /**
     * Count the number of letters in the word that are in the input
     * @param inputLetters The input letters
     * @param word The word to check
     * @return The number of letters in the word that are in the input
     */
    private static int countUsedLetters(Set<Character> inputLetters, String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (inputLetters.contains(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Check if a word can be created with the input letters
     * @param inputLetters The input letters
     * @param word The word to check
     * @return True if the word can be created with the input letters, false otherwise
     */
    private static boolean canCreateWord(Set<Character> inputLetters, String word) {
        // Use a Map to track the frequency of each letter in the word
        Map<Character, Integer> wordFrequency = new HashMap<>();

        for (char c : word.toCharArray()) {
            wordFrequency.put(c, wordFrequency.getOrDefault(c, 0) + 1);
        }

        // Check if all letters of the word are in the input and have the correct frequency
        for (Map.Entry<Character, Integer> entry : wordFrequency.entrySet()) {
            char letter = entry.getKey();
            int frequency = entry.getValue();

            if (!inputLetters.contains(letter) || inputLetters.stream().filter(c -> c == letter).count() < frequency) {
                return false;
            }
        }

        return true;
    }
}
