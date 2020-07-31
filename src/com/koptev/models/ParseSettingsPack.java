package com.koptev.models;

import com.koptev.abstractions.ParseSettings;

public class ParseSettingsPack implements ParseSettings {
    // Fields
    private final CompanyParseSettings companyParseSettings;
    private final ReviewParseSettings reviewParseSettings;
    private final CommentParseSettings commentParseSettings;

    // Constructors
    public ParseSettingsPack(CompanyParseSettings companyParseSettings, ReviewParseSettings reviewParseSettings, CommentParseSettings commentParseSettings) {
        this.companyParseSettings = companyParseSettings;
        this.reviewParseSettings = reviewParseSettings;
        this.commentParseSettings = commentParseSettings;
    }

    // Methods
    public CompanyParseSettings getCompanyParseSettings() { return companyParseSettings; }
    public ReviewParseSettings getReviewParseSettings() { return reviewParseSettings; }
    public CommentParseSettings getCommentParseSettings() { return commentParseSettings; }
}
