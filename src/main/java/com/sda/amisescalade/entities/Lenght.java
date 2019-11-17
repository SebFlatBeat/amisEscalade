package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Entity
public class Lenght implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String distance;
    private String height;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;

    public Lenght() {
    }

    public Lenght(String distance, String height) {
        this.distance = distance;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ClimbUser getClimbUser() {
        return climbUser;
    }

    public void setClimbUser(ClimbUser climbUser) {
        this.climbUser = climbUser;
    }
}
