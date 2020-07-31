package com.koptev.models;

import com.koptev.abstractions.ParseResultItem;
import com.koptev.abstractions.ParseResultList;

import java.util.ArrayList;
import java.util.List;

public class Company implements ParseResultItem {
    // Fields
    private final String name;
    private final String category;
    private final String description;
    private final int rating;
    private final int reviewsQuantity;
    private ParseResultList reviews;

    // Constructor
    public Company(String name, String category, String description, int rating, int reviewsQuantity) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.rating = rating;
        this.reviewsQuantity = reviewsQuantity;
        reviews = new ParseResultList(new ArrayList<>());
    }

    // Methods
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public Integer getRating() { return rating; }
    public Integer getReviewsQuantity() { return reviewsQuantity; }
    public Company setReviews(ParseResultList reviews) {
        if (reviews != null) {
            this.reviews = reviews;
        }
        return this;
    }
    public ParseResultList getReviews() { return reviews; }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.format("NAME: %s; CATEGORY: %s; DESCRIPTION: %s; RATING: %s; REVIEWS QUANTITY: %s; REVIEWS PARSED: %s\n",
                name,
                category,
                description == null ? "" : description.length() > 80 ? description.substring(0, 80) + "..." : description,
                rating / 100.0,
                reviewsQuantity,
                reviews.size() + (reviews.size() != 0 ? ":" : "")));
        for (ParseResultItem item: reviews) {
            output.append("\t").append(item.toString()).append("\n");
        }
        return output.toString();
    }
}
