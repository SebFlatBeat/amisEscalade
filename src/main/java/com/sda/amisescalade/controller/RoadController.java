package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.SpotDAO;
import com.sda.amisescalade.dto.SectorForm;
import com.sda.amisescalade.entities.ClimbUser;
import com.sda.amisescalade.entities.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RoadController {

    @Autowired
    SpotDAO spotDAO;

    @Autowired
    ClimbUserDAO climbUserDAO;

/**
    @PostMapping(value = "spot/{spotId}/sectorForm")
    public String saveFormRoad(@PathVariable Long spotId, Model model, @ModelAttribute("sectorForm") @Validated SectorForm sectorForm, BindingResult result, final RedirectAttributes redirectAttributes) {
        Spot spot = spotDAO.findById(spotId).get();
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        return "espacePerso";
    }
**/
}
