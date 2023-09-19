package org.example;

import java.util.Scanner;

public class GameMenu {

    public static void startTheGame()
    {
        System.out.println("\t\t\tWELCOME TO HANGMAN!");
        System.out.println("\t\tMENU");
        System.out.println("Type !rules to see the rules of of the game");
        System.out.println("[N]ew game or [E]xit?\n(Type N to start a new game or E to exit)");
        Scanner scanner = new Scanner(System.in);
        boolean startGame = true;
        while (startGame)
        {
            String inputStartKey = scanner.next().toUpperCase().trim();
            switch (inputStartKey) {
                case "E":
                    startGame = false;
                    break;
                case "!RULES":
                    printRules();
                    continue;
                case "N":
                    GameEngine.startGameLoop();
                default:
                    System.out.println("Type N to start a new game or E to exit");
            }
        }
    }
    private static void printRules()
    {
        System.out.println("You have to guess the english word by entering ONE latin alphaber LOWERCASE letter.");
        System.out.println("On every wrong guess a portion of the torso will be added to the gallows.");
        System.out.println("If the torso is drawn completely in the gallows, you lose and as punishment" +
                "\n you shall be hanged");
        System.out.println("Remark that non-alphabetic letter or letter you'd already guessed" +
                "\n(both right and wrong ones) don't count as a mistake.");
    }

    public static void main(String[] args) {
        startTheGame();
    }
}
