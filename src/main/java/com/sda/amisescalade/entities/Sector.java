package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Sector implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max=100)
    @NotBlank
    private String sectorName;
    @Size(max=500)
    private String location;
    @Size(max=200)
    private String access;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private ClimbUser climbUser;

    @OneToMany
    @Cascade(CascadeType.DETACH)
    private List<Road> road;

    public Sector() {
    }

    public Sector(String sectorName, String location, String access) {
        this.sectorName = sectorName;
        this.location = location;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
