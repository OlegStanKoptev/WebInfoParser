package com.koptev.models;

import com.koptev.abstractions.CustomParseRule;
import com.koptev.abstractions.ParseSettings;

public class ReviewParseSettings implements ParseSettings {
    // Fields
    private String reviewSelector;
    private int amountToParse;
    private boolean parseAll = false;
    private String pageSuffix;

    private String titleSelector;
    private CustomParseRule customTitleParse;

    private String nameSelector;
    private CustomParseRule customNameParse;

    private String ratingSelector;
    private CustomParseRule customRatingParse;

    private String dateSelector;
    private CustomParseRule customDateParse;

    private String textSelector;
    private CustomParseRule customTextParse;

    private String advantagesSelector;
    private CustomParseRule customAdvantagesParse;

    private String disadvantagesSelector;
    private CustomParseRule customDisadvantagesParse;

    private String likesSelector;
    private CustomParseRule customLikesParse;

    private String dislikesSelector;
    private CustomParseRule customDislikesParse;

    // Methods
    public ReviewParseSettings setReviewSelector(String selector) {
        this.reviewSelector = selector;
        return this;
    }
    public String getReviewSelector() { return reviewSelector; }

    public ReviewParseSettings setParseAll() {
        this.parseAll = true;
        return this;
    }
    public boolean getParseAll() { return parseAll; }

    public ReviewParseSettings setAmountToParse(int amount) {
        amountToParse = amount;
        return this;
    }
    public int getAmountToParse() { return amountToParse; }

    public ReviewParseSettings setPageSuffix(String suffix) {
        pageSuffix = suffix;
        return this;
    }
    public String getPageSuffix() { return pageSuffix; }

    public ReviewParseSettings setTitleSelector(String selector) {
        titleSelector = selector;
        return this;
    }
    public String getTitleSelector() { return titleSelector; }
    public ReviewParseSettings setCustomTitleParse(CustomParseRule rule) {
        customTitleParse = rule;
        return this;
    }
    public CustomParseRule getCustomTitleParse() { return customTitleParse; }

    public ReviewParseSettings setNameSelector(String selector) {
        nameSelector = selector;
        return this;
    }
    public String getNameSelector() { return nameSelector; }
    public ReviewParseSettings setCustomNameParse(CustomParseRule rule) {
        customNameParse = rule;
        return this;
    }
    public CustomParseRule getCustomNameParse() { return customNameParse; }

    public ReviewParseSettings setRatingSelector(String selector) {
        ratingSelector = selector;
        return this;
    }
    public String getRatingSelector() { return ratingSelector; }
    public ReviewParseSettings setCustomRatingParse(CustomParseRule rule) {
        customRatingParse = rule;
        return this;
    }
    public CustomParseRule getCustomRatingParse() { return customRatingParse; }

    public ReviewParseSettings setDateSelector(String selector) {
        dateSelector = selector;
        return this;
    }
    public String getDateSelector() { return dateSelector; }
    public ReviewParseSettings setCustomDateParse(CustomParseRule rule) {
        customDateParse = rule;
        return this;
    }
    public CustomParseRule getCustomDateParse() { return customDateParse; }

    public ReviewParseSettings setTextSelector(String selector) {
        textSelector = selector;
        return this;
    }
    public String getTextSelector() { return textSelector; }
    public ReviewParseSettings setCustomTextParse(CustomParseRule rule) {
        customTextParse = rule;
        return this;
    }
    public CustomParseRule getCustomTextParse() { return customTextParse; }

    public ReviewParseSettings setAdvantagesSelector(String selector) {
        advantagesSelector = selector;
        return this;
    }
    public String getAdvantagesSelector() { return advantagesSelector; }
    public ReviewParseSettings setCustomAdvantagesParse(CustomParseRule rule) {
        customAdvantagesParse = rule;
        return this;
    }
    public CustomParseRule getCustomAdvantagesParse() { return customAdvantagesParse; }

    public ReviewParseSettings setDisadvantagesSelector(String selector) {
        disadvantagesSelector = selector;
        return this;
    }
    public String getDisadvantagesSelector() { return disadvantagesSelector; }
    public ReviewParseSettings setCustomDisadvantagesParse(CustomParseRule rule) {
        customDisadvantagesParse = rule;
        return this;
    }
    public CustomParseRule getCustomDisadvantagesParse() { return customDisadvantagesParse; }

    public ReviewParseSettings setLikesSelector(String selector) {
        likesSelector = selector;
        return this;
    }
    public String getLikesSelector() { return likesSelector; }
    public ReviewParseSettings setCustomLikesParse(CustomParseRule rule) {
        customLikesParse = rule;
        return this;
    }
    public CustomParseRule getCustomLikesParse() { return customLikesParse; }

    public ReviewParseSettings setDislikesSelector(String selector) {
        dislikesSelector = selector;
        return this;
    }
    public String getDislikesSelector() { return dislikesSelector; }
    public ReviewParseSettings setCustomDislikesParse(CustomParseRule rule) {
        customDislikesParse = rule;
        return this;
    }
    public CustomParseRule getCustomDislikesParse() { return customDislikesParse; }
}
