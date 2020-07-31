package com.koptev.instances;

import com.koptev.abstractions.AddressFormatter;
import com.koptev.abstractions.WebsiteConfiguration;
import com.koptev.models.CommentParseSettings;
import com.koptev.models.CompanyParseSettings;
import com.koptev.models.ParseSettingsPack;
import com.koptev.models.ReviewParseSettings;

public class ExampleRules implements WebsiteConfiguration {
    // Fields
    private final ParseSettingsPack settingsPack;
    private final AddressFormatter formatter;
    public static ExampleRules instance;

    // Constructor
    private ExampleRules() {
        CompanyParseSettings companySettings = new CompanyParseSettings()
                .setAddressSuffix("") // example: /<suffix>
                .setNameSelector("")
                .setCategorySelector("")
                .setDescriptionSelector("")
                .setRatingSelector("")
                .setReviewsQuantitySelector("");
        ReviewParseSettings reviewSettings = new ReviewParseSettings()
                .setAmountToParse(10) // or .setParseAll()
                .setReviewPageSuffix("<pageNumber>") // must contain <pageNumber>
                .setReviewSelector("")
                .setTitleSelector("")
                .setNameSelector("")
                .setRatingSelector("")
                .setDateSelector("")
                .setTextSelector("")
                .setLikesSelector("")
                .setDislikesSelector("");
        CommentParseSettings commentSettings = new CommentParseSettings()
                .setCommentSelector("") // example: .comment_row:not(.comment_row:first-child)
                .setNameSelector("")
                .setDateSelector("")
                .setTextSelector("");

        settingsPack = new ParseSettingsPack(companySettings, reviewSettings, commentSettings);
        formatter = (address) -> WebsiteConfiguration.CleanAddress(address).split("/").length == 2;
    }

    // Methods
    public static ExampleRules getInstance() {
        if (instance == null) {
            instance = new ExampleRules();
        }
        return instance;
    }
    public static AddressFormatter getFormatter() {
        if (instance == null) {
            instance = new ExampleRules();
        }
        return instance.formatter;
    }
    public ParseSettingsPack getSettingsPack() { return settingsPack; }
}
