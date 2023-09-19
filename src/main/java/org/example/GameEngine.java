package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class GameEngine
{
    private static final int ERRORS_BOUND = 6;
    private static final Scanner scanner = new Scanner(System.in);


    public static void  startGameLoop() {
        String initialWord = WordGenerator.getWord().toLowerCase();
        System.out.println("Aight, let's go\nYou're allowed to make upto " + ERRORS_BOUND + " MISTAKES");
        HashSet<String> knownLetters = new HashSet<>();
        ArrayList<String> maskedWord = new ArrayList<>();
        maskInitialWord(maskedWord, initialWord);

        System.out.println(initialWord);
        int errorCount = 0;
        int rightGuessesCount = 0;

        while (errorCount != ERRORS_BOUND && rightGuessesCount != countDistinctLetters(initialWord))
        {
            System.out.println("\n" + maskedWord);
            String inputChar = scanner.nextLine();
            if (inputChar.length() != 1 || !Character.isAlphabetic(inputChar.charAt(0))
            || knownLetters.contains(inputChar))
            {
                System.out.println("Invalid input");
                continue;
            }
            knownLetters.add(inputChar);
            if (initialWord.contains(inputChar))
            {
                rightGuessesCount++;
                System.out.println("RIGHT!");
                openAllTheLetterOccurrencesInMask(initialWord, maskedWord, inputChar);
            }
            else
            {
                System.out.println("WRONG~");
                errorCount++;
            }
            Scaffold.printGallows(errorCount);
            System.out.println("ERRORS: " + errorCount);
            System.out.println("You've guessed: " + knownLetters);
        }
        System.out.println("THE INITIAL WORD WAS: " + initialWord);
        determineTheResult(errorCount);
    }



    private static void maskInitialWord(ArrayList<String> maskedWord, String initialWord)
    {
        for (int i = 0; i < initialWord.length(); i++) {
            maskedWord.add("*");
        }
    }
    private static void openAllTheLetterOccurrencesInMask(String initialWord, ArrayList<String> maskedWord, String letter)
    {
        for (int i = 0; i < initialWord.length(); i++) {
            if (initialWord.charAt(i) == letter.charAt(0)) {
                maskedWord.set(i, letter);
            }
        }
    }
    private static int countDistinctLetters(String word)
    {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = word.toCharArray();
        int len = word.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!map.getOrDefault(chars[i], false)) {
                map.put(chars[i], true);
                count++;
            }
        }
        return count;
    }
    private static void determineTheResult(int errorCount) {
        System.out.println("\n\t\t\tGAME OVER");
        if (errorCount == ERRORS_BOUND)
        {
            System.out.println("You lost:(");
            System.out.println("Good luck in next life:)\n");
        }else {
            System.out.println("CONGRATULATIONS!!\n");
        }
    }
}
