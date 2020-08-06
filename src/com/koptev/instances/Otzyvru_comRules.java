package com.koptev.instances;

import com.koptev.abstractions.AddressFormatter;
import com.koptev.abstractions.WebsiteConfiguration;
import com.koptev.models.CommentParseSettings;
import com.koptev.models.CompanyParseSettings;
import com.koptev.models.ParseSettingsPack;
import com.koptev.models.ReviewParseSettings;

import java.util.StringJoiner;

public final class Otzyvru_comRules implements WebsiteConfiguration {
    // Fields
    private final ParseSettingsPack settingsPack;
    private final AddressFormatter formatter;
    private static Otzyvru_comRules instance;

    // Constructor
    private Otzyvru_comRules() {
        CompanyParseSettings companySettings = new CompanyParseSettings()
                .setAddressSuffix("/info")
                .setNameSelector(".element_name")
                .setCategorySelector(".breadcrumb:nth-child(3)")
                .setDescriptionSelector(".description1")
                .setRatingSelector(".rtng_val")
                .setReviewsQuantitySelector(".count");
        ReviewParseSettings reviewSettings = new ReviewParseSettings()
                .setAmountToParse(30)
                .setPageSuffix("?page=<pageNumber>")
                .setReviewSelector(".commentbox")
                .setTitleSelector("h2")
                .setCustomNameParse((review) -> {
                    var str = review.select(".reviewer").text();
                    if (str.equals("[email protected]")) { return "Гость"; }
                    return str;
                })
                .setCustomRatingParse((review) ->
                        String.valueOf(
                                Integer.parseInt(
                                        review
                                                .select(".rating .value-title")
                                                .attr("title")
                                ) * 100
                        )
                )
                .setCustomDateParse((review) ->
                        review
                                .select(".dtreviewed .value-title")
                                .attr("title")
                )
                .setTextSelector(".description")
                .setCustomAdvantagesParse((review) -> {
                    var list = review.select(".advantages ol li");
                    StringJoiner result = new StringJoiner(";");
                    for (var item: list) {
                        result.add(item.text());
                    }
                    return result.toString();
                })
                .setCustomDisadvantagesParse((review) -> {
                    var list = review.select(".disadvantages ol li");
                    StringJoiner result = new StringJoiner(";");
                    for (var item: list) {
                        result.add(item.text());
                    }
                    return result.toString();
                });
        CommentParseSettings commentSettings = new CommentParseSettings()
                .setCommentSelector(".comment_row:not(.comment_row:first-child)")
                .setNameSelector(".author_name ins")
                .setCustomDateParse((review) ->
                        review
                                .select(".value-title")
                                .attr("title")
                )
                .setTextSelector(".comment");
        settingsPack = new ParseSettingsPack(companySettings, reviewSettings, commentSettings);
        formatter = (address) -> WebsiteConfiguration.CleanAddress(address).split("/").length == 2;
    }

    // Methods
    public static Otzyvru_comRules getInstance() {
        if (instance == null) {
            instance = new Otzyvru_comRules();
        }
        return instance;
    }
    public static AddressFormatter getFormatter() {
        if (instance == null) {
            instance = new Otzyvru_comRules();
        }
        return instance.formatter;
    }
    public ParseSettingsPack getSettingsPack() { return settingsPack; }
}
