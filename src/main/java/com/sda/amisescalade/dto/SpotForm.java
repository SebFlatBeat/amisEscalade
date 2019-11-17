package com.sda.amisescalade.dto;

public class SpotForm {
    private Long id;
    private String spotName;
    private Long spotNameId;
    private String city;
    private String department;
    private String region;
    private String country;
    private boolean tag;


    public SpotForm(String spotName, Long spotNameId, String city, String department,String region, String country, boolean tag) {
        this.spotName = spotName;
        this.spotNameId = spotNameId;
        this.city = city;
        this.department = department;
        this.region = region;
        this.country = country;
        this.tag = tag;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public Long getSpotNameId() {
        return spotNameId;
    }

    public void setSpotNameId(Long spotNameId) {
        this.spotNameId = spotNameId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isTag() {
        return tag;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

}
