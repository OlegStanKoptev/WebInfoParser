package com.koptev.models;

import com.koptev.abstractions.ParseResultItem;

public class Comment implements ParseResultItem {
    // Fields
    private final String name;
    private final String date;
    private final String text;

    // Constructors
    public Comment(String name, String date, String text) {
        this.name = name;
        this.date = date;
        this.text = text;
    }

    // Methods
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getText() { return text; }
    @Override
    public String toString() {
        return String.format("\t%s; %s; %s",
                name,
                date,
                text);
    }
}
