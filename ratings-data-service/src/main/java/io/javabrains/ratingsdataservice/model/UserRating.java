package io.javabrains.ratingsdataservice.model;

import java.util.Arrays;
import java.util.List;

public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void initData(String userId) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4),
                new Rating("300", 3),
                new Rating("400", 4),
                new Rating("500", 3),
                new Rating("600", 4),
                new Rating("700", 3),
                new Rating("800", 4),
                new Rating("900", 3),
                new Rating("910", 4)
        ));
    }
}
