package com.sda.amisescalade.dto;

public class RoadForm {
    private Long roadId;
    private Long lenghtid;
    private Long scoringId;
    private String roadName;
    private String distance;
    private String height;
    private String rating;

    public RoadForm(Long roadId, Long lenghtid, Long scoringId, String roadName, String distance, String height, String rating) {
        this.roadId = roadId;
        this.lenghtid = lenghtid;
        this.scoringId = scoringId;
        this.roadName = roadName;
        this.distance = distance;
        this.height = height;
        this.rating = rating;
    }

    public Long getRoadId() {
        return roadId;
    }

    public void setRoadId(Long roadId) {
        this.roadId = roadId;
    }

    public Long getLenghtid() {
        return lenghtid;
    }

    public void setLenghtid(Long lenghtid) {
        this.lenghtid = lenghtid;
    }

    public Long getScoringId() {
        return scoringId;
    }

    public void setScoringId(Long scoringId) {
        this.scoringId = scoringId;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
