package com.koptev.models;

import com.koptev.abstractions.ParseResultItem;
import com.koptev.abstractions.ParseResultList;

import java.util.ArrayList;

public class Review implements ParseResultItem {
    // Fields
    private final String title;
    private final String name;
    private final int rating;
    private final String date;
    private final String text;
    private final int likes;
    private final int dislikes;
    private ParseResultList comments;

    // Constructor
    public Review(String title, String name, int rating, String date, String text, int likes, int dislikes) {
        this.title = title;
        this.name = name;
        this.rating = rating;
        this.date = date;
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
        comments = new ParseResultList(new ArrayList<>());
    }

    // Methods
    public String getTitle() { return title; }
    public String getName() { return name; }
    public int getRating() { return rating; }
    public String getDate() { return date; }
    public String getText() { return text; }
    public int getLikes() { return likes; }
    public int getDislikes() { return dislikes; }
    public Review setComments(ParseResultList comments) {
        if (comments != null) {
            this.comments = comments;
        }
        return this;
    }
    public ParseResultList getComments() { return comments; }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.format("TITLE: %s; NAME: %s; RATING: %s; DATE: %s; TEXT: %s; LIKES: %s; DISLIKES: %s; COMMENTS PARSED %s",
                title.equals("") ? "NO TITLE" : title,
                name,
                rating / 100.0,
                date,
                text,
                likes,
                dislikes,
                comments.size() + (comments.size() != 0 ? ":" : "")));
        for (ParseResultItem item: comments) {
            output.append("\n\t").append(item.toString());
        }
        return output.toString();
    }
}
