package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Scoring implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String rating;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;

    @OneToOne
    private Road road;

    @OneToOne
    private Lenght lenght;

    public Scoring() {
    }

    public Scoring(String rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ClimbUser getClimbUser() {
        return climbUser;
    }

    public void setClimbUser(ClimbUser climbUser) {
        this.climbUser = climbUser;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public Lenght getLenght() {
        return lenght;
    }

    public void setLenght(Lenght lenght) {
        this.lenght = lenght;
    }
}
