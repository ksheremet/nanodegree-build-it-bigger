package com.udacity.gradle.builditbigger.backend;


import ch.builditbigger.jokes.Joker;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String joke;

    public MyBean() {
        Joker joker = new Joker();
        joke = joker.getJoke();
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String data) {
        joke = data;
    }
}