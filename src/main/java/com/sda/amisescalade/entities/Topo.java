package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;


@Entity
public class Topo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max=100)
    @NotBlank
    private String  topoName;
    @Column(columnDefinition = "boolean default true")
    private boolean available;
    private String topoCity;
    private String topoDepartement;
    private String topoCountry;
    private Date release;
    private String topoDescription;

    @ManyToOne
    @JoinColumn(name = "climb_user_id")
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;

    @ManyToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private Cartography cartography;

    public Topo() {
    }

    public Topo(@Size(max = 100) @NotBlank String topoName, boolean available, String topoCity, String topoDepartement, String topoCountry, Date release, String topoDescription) {
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

    public ClimbUser getClimbUser() {
        return climbUser;
    }

    public void setClimbUser(ClimbUser climbUser) {
        this.climbUser = climbUser;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Cartography getCartography() {
        return cartography;
    }

    public void setCartography(Cartography cartography) {
        this.cartography = cartography;
    }
}
