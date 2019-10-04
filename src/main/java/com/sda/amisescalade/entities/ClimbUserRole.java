package com.sda.amisescalade.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class ClimbUserRole implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Size(max=10)
    private String climbAdmin;
    @Size(max=10)
    private String climbUser;

    public ClimbUserRole() {
    }

    public ClimbUserRole(@Size(max = 10) String climbAdmin, @Size(max = 10) String climbUser) {
        this.climbAdmin = climbAdmin;
        this.climbUser = climbUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClimbAdmin() {
        return climbAdmin;
    }

    public void setClimbAdmin(String climbAdmin) {
        this.climbAdmin = climbAdmin;
    }

    public String getClimbUser() {
        return climbUser;
    }

    public void setClimbUser(String climbUser) {
        this.climbUser = climbUser;
    }
}
