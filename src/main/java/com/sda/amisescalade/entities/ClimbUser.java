package com.sda.amisescalade.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClimbUser implements UserDetails {
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
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<ClimbUserRole> climbUserRoleList;

    public ClimbUser() {
        this.active = true;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void grantAuthority(ClimbUserRole authority) {
        if ( climbUserRoleList == null ) climbUserRoleList = new ArrayList<>();
        climbUserRoleList.add(authority);
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        climbUserRoleList.forEach(climbUserRole -> authorities.add(new SimpleGrantedAuthority(climbUserRole.toString())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
