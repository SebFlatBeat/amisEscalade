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
    private String region;
    private String country;
    private Long nbSector;
    private boolean tag;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;

    @OneToMany
    @Cascade(CascadeType.DETACH)
    private List <CommentSpot> commentsSpot;

    @OneToMany
    @Cascade(CascadeType.DETACH)
    private List <Sector> sectors;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private Cartography cartography;

    public Spot() {
    }

    public Spot(String spotName, String city, String department,String region, String country,Long nbSector, boolean tag) {
        this.spotName = spotName;
        this.city = city;
        this.department = department;
        this.region = region;
        this.country = country;
        this.nbSector = nbSector;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city, Long codePostalCartography) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department, Long departmentCartography) {
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

    public Long getNbSector() {
        return nbSector;
    }

    public void setNbSector(Long nbSector) {
        this.nbSector = nbSector;
    }

    public boolean isTag() {
        return tag;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

    public ClimbUser getClimbUser() {
        return climbUser;
    }

    public void setClimbUser(ClimbUser climbUser) {
        this.climbUser = climbUser;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<CommentSpot> getCommentsSpot() {
        return commentsSpot;
    }

    public void setCommentsSpot(List<CommentSpot> commentsSpot) {
        this.commentsSpot = commentsSpot;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public Cartography getCartography() {
        return cartography;
    }

    public void setCartography(Cartography cartography) {
        this.cartography = cartography;
    }
}
