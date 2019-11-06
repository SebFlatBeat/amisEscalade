package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String borrower;
    private String owner;
    private String topoNameReservation;
    private Date borrowing;

    @ManyToOne
    @JoinColumn(name = "climb_user_id")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private ClimbUser climbUser;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Topo topo;

    public Reservation() {
    }

    public Reservation(String borrower, String owner, String topoNameReservation, Date borrowing) {
        this.borrower = borrower;
        this.owner = owner;
        this.topoNameReservation = topoNameReservation;
        this.borrowing = borrowing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTopoNameReservation() {
        return topoNameReservation;
    }

    public void setTopoNameReservation(String topoNameReservation) {
        this.topoNameReservation = topoNameReservation;
    }

    public Date getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Date borrowing) {
        this.borrowing = borrowing;
    }

    public ClimbUser getClimbUser() {
        return climbUser;
    }

    public void setClimbUser(ClimbUser climbUser) {
        this.climbUser = climbUser;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
}
