package com.sda.amisescalade.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue
private Long id;
    @Size(max=500)
    @NotBlank
private String texteComment;
private Date date;

@ManyToOne
@Cascade(CascadeType.DETACH)
private ClimbUser climbUser;

    public Comment() {
    }

    public Comment(String texteComment, Date date) {
        this.texteComment = texteComment;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
