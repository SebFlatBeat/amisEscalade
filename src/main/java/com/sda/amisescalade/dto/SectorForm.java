package com.sda.amisescalade.dto;


public class SectorForm {

    private String sectorName;
    private Long sectorNameId;
    private String location;
    private String access;
    private String roadName;
    private String distance;
    private String height;
    private String rating;


    public SectorForm(String sectorName,Long sectorNameId, String location, String access, String roadName, String distance, String height, String rating) {
        this.sectorName = sectorName;
        this.sectorNameId = sectorNameId;
        this.location = location;
        this.access = access;
        this.roadName = roadName;
        this.distance = distance;
        this.height = height;
        this.rating = rating;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Long getSectorNameId() {
        return sectorNameId;
    }

    public void setSectorNameId(Long sectorNameId) {
        this.sectorNameId = sectorNameId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
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
