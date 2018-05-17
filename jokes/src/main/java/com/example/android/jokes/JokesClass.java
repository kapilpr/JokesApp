package com.example.android.jokes;

import java.util.Random;

public class JokesClass {

    private String[] jokesList;
    private Random random;

    public JokesClass() {

        jokesList = new String[10];
        jokesList[0] = "If you want to catch a squirrel just climb a tree and act like a nut.";
        jokesList[1] = "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.";
        jokesList[2] = "How do you make holy water? You boil the hell out of it.";
        jokesList[3] = "What's the difference between snowmen and snowladies? Snowballs";
        jokesList[4] = "I am a nobody, nobody is perfect, therefore I am perfect.";
        jokesList[5] = "If con is the opposite of pro, it must mean Congress is the opposite of progress?";
        jokesList[6] = "What do you call two fat people having a chat? -- A heavy discussion";
        jokesList[7] = "My mom never saw the irony in calling me a son-of-a-bitch.";
        jokesList[8] = "I used to like my neighbors, until they put a password on their Wi-Fi.";
        jokesList[9] = "Light travels faster than sound. This is why some people appear bright until they speak.";

        random = new Random();
    }

    public String[] getJokes() {
        return jokesList;
    }

    public String getRandomJoke() {
        return jokesList[random.nextInt(jokesList.length)];
    }
}
