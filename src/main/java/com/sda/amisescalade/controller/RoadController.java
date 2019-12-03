package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.*;
import com.sda.amisescalade.dto.SectorForm;
import com.sda.amisescalade.entities.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RoadController {

    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Autowired
    private SectorDAO sectorDAO;

    @Autowired
    private ScoringDAO scoringDAO;

    @Autowired
    private RoadDAO roadDAO;

    @Autowired
    private LenghtDAO lenghtDAO;

    @GetMapping(value = "/spot/{spotId}/sector/{sectorId}/roadForm")
    public String getFormRoad(@PathVariable Long sectorId, @PathVariable Long spotId) {
        return "/formRoad";
    }

    @PostMapping(value = "/spot/{spotId}/sector/{sectorId}/roadForm")
    public String saveFormRoad(@PathVariable Long sectorId,@PathVariable Long spotId, Model model, @ModelAttribute("sectorForm") @Validated SectorForm sectorForm, BindingResult result, final RedirectAttributes redirectAttributes){
        Sector sector = sectorDAO.findById(sectorId).get();
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Road road = new Road();
        road.setClimbUser(climbUser);
        road.setSector(sector);
        road.setRoadName(sectorForm.getRoadName());
        roadDAO.save(road);
        Lenght lenght = new Lenght();
        lenght.setClimbUser(climbUser);
        lenght.setDistance(sectorForm.getDistance());
        lenght.setHeight(sectorForm.getHeight());
        lenght.setRoad(road);
        lenghtDAO.save(lenght);
        Scoring scoring = new Scoring();
        scoring.setClimbUser(climbUser);
        scoring.setRoad(road);
        scoring.setLenght(lenght);
        scoring.setRating(sectorForm.getRating());
        scoringDAO.save(scoring);
        return "redirect:/spot/{spotId}/sector/{sectorId}/sectorDetails";
    }

    @PostMapping("/road/{roadId}/deleteRoad")
    public String deleteRoad (@PathVariable Long roadId) {
        Road road = roadDAO.findById(roadId).get();
        roadDAO.delete(road);
        return "redirect:/espacePerso";
    }
}
