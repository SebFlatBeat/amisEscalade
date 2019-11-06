package com.sda.amisescalade.dto;

import java.sql.Date;

public class ReservationForm {

    private Long id;
    private String borrower;
    private String owner;
    private String topoNameReservation;
    private Date borrowing;
    private Long ownerId;
    private Long topoId;

    public ReservationForm() {
    }

    public ReservationForm(String borrower, String owner, String topoNameReservation, Date borrowing, Long ownerId, Long topoId) {
        this.borrower = borrower;
        this.owner = owner;
        this.topoNameReservation = topoNameReservation;
        this.borrowing = borrowing;
        this.ownerId = ownerId;
        this.topoId = topoId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getTopoId() {
        return topoId;
    }

    public void setTopoId(Long topoId) {
        this.topoId = topoId;
    }
}
