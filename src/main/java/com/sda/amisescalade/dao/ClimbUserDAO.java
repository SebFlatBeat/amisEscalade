package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.ClimbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;


public interface ClimbUserDAO extends JpaRepository <ClimbUser,Long> {

 ClimbUser findClimbUserByUserName(String name);

 ClimbUser findClimbUserByEmail(String mail);

 Optional<ClimbUser> findByUserName(String username);

}
