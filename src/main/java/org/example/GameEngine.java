package org.example;


import java.util.*;

public final class GameEngine {
    private static String WORD;
    private static int errorNum;
    private static ArrayList<Character> guesses;
    private static StringBuilder wordMask;
    private static ArrayList<Character> remainingLetters;
    
    public static void gameProcess()
    {
        System.out.println("""
                \n\t\t\t\tWELCOME TO HANGMAN!
                Do you wanna start a new game, gambler?
                (Type Y to start)""");
        init();
        System.out.println(WORD);




        Scanner scanner = new Scanner(System.in);
        String inputKey = scanner.nextLine();
        if (inputKey.trim().equalsIgnoreCase("Y")) {
            startTheGame();
            determineTheResult();
        } else {
            System.out.println("You quited the game ;(");
        }
    }


    private static void startTheGame() {
        System.out.println("Aight, let's go!\n");
        Scanner scanner = new Scanner(System.in);
        while (errorNum != 6 && !wordMask.toString().equals(WORD))
        {
            System.out.println("BEING GUESSED WORD: " + wordMask);
            System.out.println("Already known: " +  guesses);
            System.out.print("\nYOUR GUESS: ");
            String inputLine = scanner.nextLine();
            if (inputValidation(inputLine))
            {
                continue;
            }
            char guess = inputLine.charAt(0);
            guesses.add(guess);
            processUserGuess(guess);
        }
    }

    private static void init() {
        guesses = new ArrayList<>();
        wordMask = new StringBuilder();
        errorNum = 0;
        WORD = WordGenerator.getWord().toLowerCase();
        Set<Character> set = new HashSet<>();
        char[] chars = WORD.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        remainingLetters = new ArrayList<>(set);
        chooseLettersToShow(2);
        int len = WORD.length();
        for (int i = 0; i < len; i++) {
            if (guesses.contains(WORD.charAt(i)))
            {
                wordMask.append(WORD.charAt(i));
            }else {
                wordMask.append('*');
            }
        }
    }


    private static void processUserGuess(char guess) {
        if (remainingLetters.contains(guess))
        {
            int letterIndex = WORD.indexOf(guess);
            System.out.println("RIGHT!");
            remainingLetters.remove(remainingLetters.indexOf(guess));
            while (letterIndex != -1)
            {
                wordMask.setCharAt(letterIndex, guess);
                letterIndex = WORD.indexOf(guess, letterIndex+1);
            }
        }
        else
        {
            errorNum++;
            System.out.println("WRONG~");
            System.out.println(Scaffold.getGallows(errorNum));
        }
    }

    private static boolean inputValidation(String inputLine) {
        if (inputLine.length() == 1 &&  Character.isAlphabetic(inputLine.charAt(0))
            && !guesses.contains(inputLine.charAt(0)))
        {
            return false;
        }
        else
        {
            System.out.println("Invalid guess or you'd already guessed this");
            return true;
        }
    }


    private static void chooseLettersToShow(int k)
    {
        Random random = new Random();
        while (k > 0)
        {
            int index = random.nextInt(0, remainingLetters.size());
            guesses.add(remainingLetters.get(index));
            remainingLetters.remove(index);
            k--;
        }
    }
    private static void determineTheResult() {
        if (errorNum == 6) {
            System.out.println("The actual word was: " + WORD +
                    "\nGood luck next time");
        }
        else{
            System.out.println("YOU WON! ^^");
        }
        restartOrQuit();
    }

    private static void restartOrQuit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you wanna play again?\n(Type Y to start a new game)");
        String inputExitKey = scanner.nextLine();
        if (inputExitKey.trim().equalsIgnoreCase("Y"))
        {
            startTheGame();
        }
    }

    public static void main(String[] args) {
        gameProcess();
    }
}
