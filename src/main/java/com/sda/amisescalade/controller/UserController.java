package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.TopoDAO;
import com.sda.amisescalade.entities.ClimbUser;
import com.sda.amisescalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private ClimbUserDAO climbUserDAO;
    @Autowired
    private TopoDAO topoDAO;
    /**
     *
     * @return index
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     *
     * @return espacePerso
     */
    @RequestMapping("/espacePerso")
    public String espacePerso(Model model) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        List<Topo> topoUser = topoDAO.findTopoByClimbUserId(climbUser.getId());
        model.addAttribute("topoUser", topoUser);
        return "espacePerso";}

}
