package com.sda.amisescalade.dto;

import java.util.Date;

public class CommentForm {

    private Long id;
    private Long climbUserId;
    private Long spotId;
    private Long sectorId;
    private String texteComment;
    private Date date = new Date();

    public CommentForm() {
    }

    public CommentForm(Long id, Long climbUserId, Long spotId, Long sectorId, String texteComment, Date date) {
        this.id = id;
        this.climbUserId = climbUserId;
        this.spotId = spotId;
        this.sectorId = sectorId;
        this.texteComment = texteComment;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClimbUserId() {
        return climbUserId;
    }

    public void setClimbUserId(Long climbUserId) {
        this.climbUserId = climbUserId;
    }

    public Long getSpotId() {
        return spotId;
    }

    public void setSpotId(Long spotId) {
        this.spotId = spotId;
    }

    public Long getSectorId() {
        return sectorId;
    }

    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }

    public String getTexteComment() {
        return texteComment;
    }

    public void setTexteComment(String texteComment) {
        this.texteComment = texteComment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
