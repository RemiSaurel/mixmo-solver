package fr.saurel.remi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Board {
    /**
     * Find the words that can be created with the input letters
     * @param input The input letters
     * @return A list of words that can be created with the input letters, or an empty list if no words were found
     */
    public static List<String> findPossibleWordList(ArrayList<Character> input) {
        List<String> possibleWordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.txt"))) {
            // Read all lines at once for efficiency
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Sort the words based on the number of letters used (max first)
            lines.sort((o1, o2) -> countUsedLetters(input, o2) - countUsedLetters(input, o1));

            // Find words that can be created with the input letters
            for (String word : lines) {
                if (canCreateWord(input, word)) {
                    possibleWordList.add(word);
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
    private static int countUsedLetters(ArrayList<Character> inputLetters, String word) {
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
    private static boolean canCreateWord(ArrayList<Character> inputLetters, String word) {
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
