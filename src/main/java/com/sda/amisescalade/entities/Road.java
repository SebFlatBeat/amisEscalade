package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Road implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String roadName;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;

    @OneToMany
    @Cascade(CascadeType.DETACH)
    private List <Lenght> lenghts;

    public Road() {
    }

    public Road(String roadName) {
        this.roadName = roadName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public ClimbUser getClimbUser() {
        return climbUser;
    }

    public void setClimbUser(ClimbUser climbUser) {
        this.climbUser = climbUser;
    }

    public List<Lenght> getLenghts() {
        return lenghts;
    }

    public void setLenghts(List<Lenght> lenghts) {
        this.lenghts = lenghts;
    }
}
