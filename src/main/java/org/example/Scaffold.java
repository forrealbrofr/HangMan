package org.example;

public class Scaffold {

    public static void printGallows(int errorsCount)
    {
        System.out.println("╔ ═ ═ ═ ═ ═ ═ ═");
        System.out.println("║" + (errorsCount > 0 ? "           │" : ""));
        System.out.println("║" + (errorsCount > 0 ? "           ◯" : ""));
        System.out.println("║" + (errorsCount > 2 ? "          /" : "") + (errorsCount > 1 ? "│" : "") + (errorsCount > 3 ? "\\" : ""));
        System.out.println("║" + (errorsCount > 4 ? "          /" : "") + (errorsCount > 5 ? " \\" : ""));
        System.out.println("║");
        System.out.println("║");
        System.out.println("╚═ ═ ═ ═ ═ ═ ═ ═ ");
    }
}
