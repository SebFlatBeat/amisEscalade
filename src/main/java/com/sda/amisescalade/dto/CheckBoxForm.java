package com.sda.amisescalade.dto;

import com.sda.amisescalade.entities.Spot;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Transactional
public class CheckBoxForm {

    private Long id;
    private String topoName;
    private boolean available;
    private String topoCity;
    private String topoDepartement;
    private String topoCountry;
    private Date release;
    private String topoDescription;
    private String availability;

    private Spot spot;

    public CheckBoxForm() {
    }

    public CheckBoxForm(Long id, String topoName, boolean available, String topoCity, String topoDepartement, String topoCountry, Date release, String topoDescription) {
        this.id = id;
        this.topoName = topoName;
        this.available = available;
        this.topoCity = topoCity;
        this.topoDepartement = topoDepartement;
        this.topoCountry = topoCountry;
        this.release = release;
        this.topoDescription = topoDescription;
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

    public String getTopoDescription() {
        return topoDescription;
    }

    public void setTopoDescription(String topoDescription) {
        this.topoDescription = topoDescription;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public boolean getRealAvailability (){
        if(availability == null){
            return false;
        }else if (availability.equals("on"))
            return true;
        return false;
    }
}
