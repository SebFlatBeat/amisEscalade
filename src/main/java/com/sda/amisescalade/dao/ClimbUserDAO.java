package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.ClimbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;


public interface ClimbUserDAO extends JpaRepository <ClimbUser,Long> {

 public ClimbUser findClimbUserByUserName(String name);

 public ClimbUser findClimbUserByEmail(String mail);

 Optional<ClimbUser> findByUserName(String username);

}
