package org.example;

public class Scaffold {
    private static final StringBuilder GALLOWS = new StringBuilder("""
                 ________________________________
                |                 |
                |                 |
                |                /--\\
                |               |    |
                |                \\__/
                |          /  |^^^^^^^|  \\
                |        /   |         |   \\
                |      /    |           |    \\
                |     /      |         |      \\
                |             |-------|
                |           /           \\
                |          /             \\
                |         /               \\
                |        /                 \\
                |
                |
                |
                |
                |
                |
                |
                |
                |""");
    public static String getGallows(int numberOfErrors)
    {
        return switch (numberOfErrors) {
            case 0 -> GALLOWS.substring(0, 32) + GALLOWS.substring(397);
            case 1 -> GALLOWS.substring(0, 140) + GALLOWS.substring(397);
            case 2 -> GALLOWS.substring(0, 140) +
                      GALLOWS.substring(140, 395).replaceAll("[\\\\/]", " ");
            case 3 -> GALLOWS.substring(0, 140) +
                      GALLOWS.substring(140, 290).replaceAll("/", " ") + GALLOWS.substring(397);
            case 4 -> GALLOWS.substring(0, 140) + GALLOWS.substring(140, 290) + GALLOWS.substring(397);
            case 5 -> GALLOWS.substring(0, 282) + GALLOWS.substring(282).replaceAll("/", "");
            case 6 -> GALLOWS.toString();
            default -> throw new IllegalArgumentException("Invalid number of errors");
        };
    }
}
