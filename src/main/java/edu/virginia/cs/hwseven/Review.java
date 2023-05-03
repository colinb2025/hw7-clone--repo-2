package edu.virginia.cs.hwseven;

public class Review {
    private String writtenBy;
    private String reviewText;
    private int rating;

    public Review(String writtenBy, String reviewText, int rating) {
        this.writtenBy = writtenBy;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating>5||rating<1){
            throw new IllegalArgumentException("ratings must be between 1 and 5");
        }
        this.rating = rating;
    }
}
