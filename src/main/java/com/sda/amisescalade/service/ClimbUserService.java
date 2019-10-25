package com.sda.amisescalade.service;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.entities.ClimbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class ClimbUserService implements UserDetailsService {
    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<ClimbUser> climbUser = climbUserDAO.findByUserName(s);

        if (climbUser.isPresent()){
            return climbUser.get();
        }else{
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }
    }
}
