package com.sda.amisescalade.service;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.entities.ClimbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class ClimbUserService implements UserDetailsService {
    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ClimbUser> climbUser = climbUserDAO.findByUserName(username);

        if (climbUser.isPresent()){
            return climbUser.get();
        }else{
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }

    }

}
