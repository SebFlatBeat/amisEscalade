package com.sda.amisescalade.entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
public class ClimbUser implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max=50)
    @NotBlank
    private String userName;
    @Size(max=100)
    @NotBlank
    private String email;
    @Size(max=100)
    @NotBlank
    private String password;
    @Column(columnDefinition = "boolean default true")
    private boolean active;

    public ClimbUser() {
    }

    public ClimbUser(@Size(max = 50) @NotBlank String userName, @Size(max = 100) @NotBlank String email, @Size(max = 100) @NotBlank String password, boolean active) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
