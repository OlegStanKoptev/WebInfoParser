package com.koptev;

import com.koptev.abstractions.*;
import com.koptev.models.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parser supports sites: "otzyvru.com"
 */
public class ParseService {
    private final Boolean developerMode;
    public ParseService() { developerMode = false; }
    public ParseService(Boolean developerMode) { this.developerMode = developerMode; }

    public ParseResultList Parse(@NotNull List<String> addresses) {
        List<ParseResultItem> result = new ArrayList<>();
        Document page;
        if (developerMode) { System.out.println("Parsing company info..."); }
        for (String address: addresses) {
            var settingsPack = WebsiteConfiguration.getSettingsPack(address);
            if (settingsPack == null) {
                if (developerMode) { System.out.println("The link is broken"); }
                return null;
            }
            CompanyParseSettings settings = settingsPack.getCompanyParseSettings();
            try {
                String name = "";
                String category = "";
                String description = "";
                int rating = 0;
                int reviewsQuantity = 0;
                page = Jsoup.connect(address + settings.getAddressSuffix()).get();
                try {
                    if (settings.getNameSelector() != null) {
                        name = page.select(settings.getNameSelector()).first().text();
                    } else if (settings.getCustomNameParse() != null) {
                        name = settings.getCustomNameParse().Parse(page);
                    }
                } catch (Exception ignored) { }
                try {
                    if (settings.getCategorySelector() != null) {
                        category = page.select(settings.getCategorySelector()).first().text();
                    } else if (settings.getCustomCategoryParse() != null) {
                        category = settings.getCustomCategoryParse().Parse(page);
                    }
                } catch (Exception ignored) { }
                try {
                    if (settings.getDescriptionSelector() != null) {
                        description = page.select(settings.getDescriptionSelector()).first().text();
                    } else if (settings.getCustomDescriptionParse() != null) {
                        description = settings.getCustomDescriptionParse().Parse(page);
                    }
                } catch (Exception ignored) { }
                try {
                    if (settings.getRatingSelector() != null) {
                        rating = (int)(Double.parseDouble(page.select(settings.getRatingSelector()).first().text().replace(" ", "")) * 100);
                    } else if (settings.getCustomRatingParse() != null) {
                        rating = Integer.parseInt(settings.getCustomRatingParse().Parse(page));
                    }
                } catch (Exception ignored) { }
                try {
                    if (settings.getReviewsQuantitySelector() != null) {
                        reviewsQuantity = Integer.parseInt(page.select(settings.getReviewsQuantitySelector()).first().text().replace(" ", ""));
                    } else if (settings.getCustomReviewsQuantityParse() != null) {
                        reviewsQuantity = Integer.parseInt(settings.getCustomReviewsQuantityParse().Parse(page));
                    }
                } catch (Exception ignored) { }
                result.add(new Company(name, category, description, rating, reviewsQuantity)
                        .setReviews(ParseReviews(address, settingsPack, reviewsQuantity))
                );
            } catch (Exception ex) {
                if (developerMode) {
                    System.out.println("Error occurred while parsing:");
                    System.out.println(Arrays.toString(ex.getStackTrace()));
                }
            }
        }
        if (developerMode) { System.out.println("Finished parsing companies"); }
        return new ParseResultList(result);
    }

    private @Nullable
    ParseResultList ParseReviews(String address, ParseSettingsPack settingsPack, int overallReviews) {
        if (settingsPack.getReviewParseSettings() == null) { return null; }
        ReviewParseSettings settings = settingsPack.getReviewParseSettings();
        if (developerMode) { System.out.println("Parsing review info..."); }
        int amountToParse = 1;
        if (settings.getParseAll()) {
            amountToParse = overallReviews;
        } else if (settings.getAmountToParse() != 0 && settings.getAmountToParse() <= overallReviews) {
            amountToParse = settings.getAmountToParse();
        }
        String suffix = settings.getPageSuffix();
        int savedReviews = 0;
        int currentPage = 1;
        var result = new ArrayList<ParseResultItem>();
        try {
            do {
                var page = Jsoup.connect(address + suffix.replace("<pageNumber>", String.valueOf(currentPage++))).get();
                var reviews = page.select(settings.getReviewSelector());
                for (Element review: reviews) {
                    String title = "";
                    String name = "";
                    int rating = 0;
                    String date = "";
                    String text = "";
                    String advantages = "";
                    String disadvantages = "";
                    int likes = 0;
                    int dislikes = 0;
                    try {
                        if (settings.getTitleSelector() != null) {
                            title = review.select(settings.getTitleSelector()).first().text();
                        } else if (settings.getCustomTitleParse() != null) {
                            title = settings.getCustomTitleParse().Parse(review);
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getNameSelector() != null) {
                            name = review.select(settings.getNameSelector()).first().text();
                        } else if (settings.getCustomNameParse() != null) {
                            name = settings.getCustomNameParse().Parse(review);
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getRatingSelector() != null) {
                            rating = (int)(Double.parseDouble(review.select(settings.getRatingSelector()).first().text().replace(" ", "")) * 100);
                        } else if (settings.getCustomRatingParse() != null) {
                            rating = Integer.parseInt(settings.getCustomRatingParse().Parse(review));
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getDateSelector() != null) {
                            date = review.select(settings.getDateSelector()).first().text();
                        } else if (settings.getCustomDateParse() != null) {
                            date = settings.getCustomDateParse().Parse(review);
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getTextSelector() != null) {
                            text = review.select(settings.getTextSelector()).first().text();
                        } else if (settings.getCustomTextParse() != null) {
                            text = settings.getCustomTextParse().Parse(review);
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getAdvantagesSelector() != null) {
                            advantages = review.select(settings.getAdvantagesSelector()).first().text();
                        } else if (settings.getCustomAdvantagesParse() != null) {
                            advantages = settings.getCustomAdvantagesParse().Parse(review);
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getDisadvantagesSelector() != null) {
                            disadvantages = review.select(settings.getDisadvantagesSelector()).first().text();
                        } else if (settings.getCustomDisadvantagesParse() != null) {
                            disadvantages = settings.getCustomDisadvantagesParse().Parse(review);
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getLikesSelector() != null) {
                            likes = Integer.parseInt(review.select(settings.getLikesSelector()).text());
                        } else if (settings.getCustomLikesParse() != null) {
                            likes = Integer.parseInt(settings.getCustomLikesParse().Parse(review));
                        }
                    } catch (Exception ignored) { }
                    try {
                        if (settings.getDislikesSelector() != null) {
                            dislikes = Integer.parseInt(review.select(settings.getDislikesSelector()).text());
                        } else if (settings.getCustomDislikesParse() != null) {
                            dislikes = Integer.parseInt(settings.getCustomDislikesParse().Parse(review));
                        }
                    } catch (Exception ignored) { }
                    result.add(new Review(title, name, rating, date, text, advantages, disadvantages, likes, dislikes)
                            .setComments(ParseComments(review, settingsPack))
                    );
                    savedReviews++;
                    if (savedReviews == amountToParse) {
                        break;
                    }
                }
            } while (savedReviews < amountToParse);
        } catch (Exception ex) {
            if (developerMode) {
                System.out.println("Error occurred while parsing:");
                System.out.println(Arrays.toString(ex.getStackTrace()));
            }
        }
        if (developerMode) { System.out.println("Finished parsing reviews"); }
        return new ParseResultList(result);
    }

    private @Nullable
    ParseResultList ParseComments(Element review, ParseSettingsPack settingsPack) {
        if (settingsPack.getCommentParseSettings() == null) { return null; }
        CommentParseSettings settings = settingsPack.getCommentParseSettings();
        var comments = review.select(settings.getCommentSelector());
        var result = new ArrayList<ParseResultItem>();
        for (Element comment: comments) {
            String name = "";
            String date = "";
            String text = "";
            try {
                if (settings.getNameSelector() != null) {
                    name = comment.select(settings.getNameSelector()).text();
                } else if (settings.getCustomNameParse() != null) {
                    name = settings.getCustomNameParse().Parse(comment);
                }
            } catch (Exception ignored) { }
            try {
                if (settings.getDateSelector() != null) {
                    date = comment.select(settings.getDateSelector()).text();
                } else if (settings.getCustomDateParse() != null) {
                    date = settings.getCustomDateParse().Parse(comment);
                }
            } catch (Exception ignored) { }
            try {
                if (settings.getTextSelector() != null) {
                    text = comment.select(settings.getTextSelector()).text();
                } else if (settings.getCustomTextParse() != null) {
                    text = settings.getCustomTextParse().Parse(comment);
                }
            } catch (Exception ignored) { }
            result.add(new Comment(name, date, text));
        }
        return new ParseResultList(result);
    }
}

