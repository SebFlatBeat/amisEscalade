package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Topo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max=100)
    @NotBlank
    private String  topoName;
    private boolean available;
    private String topoCity;
    private String topoDepartement;
    private String topoCountry;
    private Date release;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;


    public Topo() {
    }

    public Topo(String topoName, boolean available, String topoCity, String topoDepartement, String topoCountry, Date release) {
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
