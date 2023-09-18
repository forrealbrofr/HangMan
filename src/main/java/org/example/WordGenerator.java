package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public final class WordGenerator {
    private static Document page;

    private static void loadPage() {
        try {
            URL URL = new URL("https://coolgenerator.com/word-generator");
            page =  Jsoup.parse(URL, 3000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getWord()
    {
        loadPage();
        String word = String.valueOf(page.select("p[class=text-center font-18]").first());
        return word.substring(40, word.length() - 15);
    }

    public WordGenerator() {
    }
}
