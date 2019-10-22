package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.ClimbUser;
import com.sda.amisescalade.entities.ClimbUserForm;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.*;


public interface ClimbUserDAO extends JpaRepository <ClimbUser,Long> {

 public ClimbUser findClimbUserByUserName(String name);

 public ClimbUser findClimbUserByEmail(String mail);

 Optional<ClimbUser> findByUserName(String username);

}
