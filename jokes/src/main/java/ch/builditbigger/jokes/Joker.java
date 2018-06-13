package ch.builditbigger.jokes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {

    private List<String> jokes = new ArrayList<>(Arrays.asList(
            "Programmer (noun.)\nA machine that turns coffee into code.",
            "Programmer (noun.)\nA person who fixed a problem that you don't know you have, in a way you don't understand",
            "Algorithm (noun.)\nWord used by programmers when... they do not want to explain what they did.",
            "Hardware (noun.)\nThe part of a computer that you can kick.",
            "Q: What's the object-oriented way to become wealthy?\nA: Inheritance",
            "Q: What do you call a programmer from Finland?\nA: Nerdic",
            "Q: What is a programmer's favourite hangout place?\nA: Foo Bar",
            "Q: 0 is false and 1 is true, right?\nA: 1",
            "Real programmers count from 0. ",
            "3 Database SQL walked into a NoSQL bar.\nA little while later... they walked out\nBecause they couldn't find a table."
    ));


    public String getJoke() {
        Random rand = new Random();
        int randNum = rand.nextInt(10);
        return jokes.get(randNum);
    }
}
