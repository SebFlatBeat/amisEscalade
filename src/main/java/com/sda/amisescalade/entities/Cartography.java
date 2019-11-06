package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cartography {
    @Id
    @GeneratedValue
    private Long id;

    private String countryCartography;
    private String regionCartography;
    private Long departmentCartography;
    private String communeCartography;
    private Long codePostalCartography;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private Spot spot;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    private Topo topo;

    public Cartography() {
    }

    public Cartography(String countryCartography, String regionCartography, Long departmentCartography, String communeCartography, Long codePostalCartography) {
        this.countryCartography = countryCartography;
        this.regionCartography = regionCartography;
        this.departmentCartography = departmentCartography;
        this.communeCartography = communeCartography;
        this.codePostalCartography = codePostalCartography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCartography() {
        return countryCartography;
    }

    public void setCountryCartography(String countryCartography) {
        this.countryCartography = countryCartography;
    }

    public String getRegionCartography() {
        return regionCartography;
    }

    public void setRegionCartography(String regionCartography) {
        this.regionCartography = regionCartography;
    }

    public Long getDepartmentCartography() {
        return departmentCartography;
    }

    public void setDepartmentCartography(Long departmentCartography) {
        this.departmentCartography = departmentCartography;
    }

    public String getCommuneCartography() {
        return communeCartography;
    }

    public void setCommuneCartography(String communeCartography) {
        this.communeCartography = communeCartography;
    }

    public Long getCodePostalCartography() {
        return codePostalCartography;
    }

    public void setCodePostalCartography(Long codePostalCartography) {
        this.codePostalCartography = codePostalCartography;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
}
