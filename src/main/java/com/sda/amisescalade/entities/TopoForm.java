package com.sda.amisescalade.entities;

import java.util.Date;

public class TopoForm {

    private Long id;
    private String topoName;
    private boolean available;
    private String topoCity;
    private String topoDepartement;
    private String topoCountry;
    private Date release;

    public TopoForm() {
    }

    public TopoForm(Long id, String topoName, boolean available, String topoCity, String topoDepartement, String topoCountry, Date release) {
        this.id = id;
        this.topoName = topoName;
        this.available = available;
        this.topoCity = topoCity;
        this.topoDepartement = topoDepartement;
        this.topoCountry = topoCountry;
        this.release = release;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopoName() {
        return topoName;
    }

    public void setTopoName(String topoName) {
        this.topoName = topoName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTopoCity() {
        return topoCity;
    }

    public void setTopoCity(String topoCity) {
        this.topoCity = topoCity;
    }

    public String getTopoDepartement() {
        return topoDepartement;
    }

    public void setTopoDepartement(String topoDepartement) {
        this.topoDepartement = topoDepartement;
    }

    public String getTopoCountry() {
        return topoCountry;
    }

    public void setTopoCountry(String topoCountry) {
        this.topoCountry = topoCountry;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }
}
