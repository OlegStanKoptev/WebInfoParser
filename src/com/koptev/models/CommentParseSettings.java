package com.koptev.models;

import com.koptev.abstractions.CustomParseRule;
import com.koptev.abstractions.ParseSettings;

public class CommentParseSettings implements ParseSettings {
    // Fields
    private String commentSelector;

    private String nameSelector;
    private CustomParseRule customNameParse;

    private String dateSelector;
    private CustomParseRule customDateParse;

    private String textSelector;
    private CustomParseRule customTextParse;

    // Methods
    public CommentParseSettings setCommentSelector(String selector) {
        commentSelector = selector;
        return this;
    }
    public String getCommentSelector() { return commentSelector; }

    public CommentParseSettings setNameSelector(String selector) {
        this.nameSelector = selector; return this;
    }
    public String getNameSelector() { return nameSelector; }
    public CommentParseSettings setCustomNameParse(CustomParseRule rule) {
        this.customNameParse = rule;
        return this;
    }
    public CustomParseRule getCustomNameParse() { return customNameParse; }

    public CommentParseSettings setDateSelector(String selector) {
        this.dateSelector = selector;
        return this;
    }
    public String getDateSelector() { return dateSelector; }
    public CommentParseSettings setCustomDateParse(CustomParseRule rule) {
        customDateParse = rule;
        return this;
    }
    public CustomParseRule getCustomDateParse() { return customDateParse; }

    public CommentParseSettings setTextSelector(String selector) {
        this.textSelector = selector;
        return this;
    }
    public String getTextSelector() { return textSelector; }
    public CommentParseSettings setCustomTextParse(CustomParseRule rule) {
        customTextParse = rule;
        return this;
    }
    public CustomParseRule getCustomTextParse() { return customTextParse; }

}
