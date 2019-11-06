package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Spot implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String spotName;
    private String city;
    private String department;
    private String country;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;

    @OneToMany
    @Cascade(CascadeType.DETACH)
    private List <Comment> comments;

    @OneToMany
    @Cascade(CascadeType.DETACH)
    private List <Sector> sectors;

    public Spot() {
    }

    public Spot(String spotName, String city, String department, String country) {
        this.spotName = spotName;
        this.city = city;
        this.department = department;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
