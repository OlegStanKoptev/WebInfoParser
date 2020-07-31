package com.koptev.models;

import com.koptev.abstractions.CustomParseRule;
import com.koptev.abstractions.ParseSettings;

public class CompanyParseSettings implements ParseSettings {
    // Fields
    private String addressSuffix = "";

    private String nameSelector;
    private CustomParseRule customNameParse;

    private String categorySelector;
    private CustomParseRule customCategoryParse;

    private String descriptionSelector;
    private CustomParseRule customDescriptionParse;

    private String ratingSelector;
    private CustomParseRule customRatingParse;

    private String reviewsQuantitySelector;
    private CustomParseRule customReviewsQuantityParse;

    // Methods
    public CompanyParseSettings setAddressSuffix(String suffix) {
        addressSuffix = suffix;
        return this;
    }
    public String getAddressSuffix() { return addressSuffix; }

    public CompanyParseSettings setNameSelector(String selector) {
        nameSelector = selector;
        return this;
    }
    public String getNameSelector() { return nameSelector; }
    public CompanyParseSettings setCustomNameParse(CustomParseRule rule) {
        customNameParse = rule;
        return this;
    }
    public CustomParseRule getCustomNameParse() { return customNameParse; }

    public CompanyParseSettings setCategorySelector(String selector) {
        categorySelector = selector;
        return this;
    }
    public String getCategorySelector() { return categorySelector; }
    public CompanyParseSettings setCustomCategoryParse(CustomParseRule rule) {
        customCategoryParse = rule;
        return this;
    }
    public CustomParseRule getCustomCategoryParse() { return customCategoryParse; }

    public CompanyParseSettings setDescriptionSelector(String selector) {
        descriptionSelector = selector;
        return this;
    }
    public String getDescriptionSelector() { return descriptionSelector; }
    public CompanyParseSettings setCustomDescriptionParse(CustomParseRule rule) {
        customDescriptionParse = rule;
        return this;
    }
    public CustomParseRule getCustomDescriptionParse() { return customDescriptionParse; }

    public CompanyParseSettings setRatingSelector(String selector) {
        ratingSelector = selector;
        return this;
    }
    public String getRatingSelector() { return ratingSelector; }
    public CompanyParseSettings setCustomRatingParse(CustomParseRule rule) {
        customRatingParse = rule;
        return this;
    }
    public CustomParseRule getCustomRatingParse() { return customRatingParse; }

    public CompanyParseSettings setReviewsQuantitySelector(String selector) {
        reviewsQuantitySelector = selector;
        return this;
    }
    public String getReviewsQuantitySelector() { return reviewsQuantitySelector; }
    public CompanyParseSettings setCustomReviewsQuantityParse(CustomParseRule rule) {
        customReviewsQuantityParse = rule;
        return this;
    }
    public CustomParseRule getCustomReviewsQuantityParse() { return customReviewsQuantityParse; }
}
