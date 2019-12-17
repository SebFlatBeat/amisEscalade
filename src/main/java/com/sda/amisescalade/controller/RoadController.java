package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.*;
import com.sda.amisescalade.dto.RoadForm;
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

import java.util.Optional;

@Controller
public class RoadController {

    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Autowired
    private SpotDAO spotDAO;

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

    @PostMapping(value = "/spot/{spotId}/sector/{sectorId}/road/{roadId}/lenght/{lenghtId}/scoring/{scoringId}/updateRoadForm")
    public String updateRoad(@PathVariable Long spotId, @PathVariable Long sectorId, @PathVariable Long roadId,@PathVariable Long lenghtId,@PathVariable Long scoringId, Model model, @ModelAttribute("formRoad")RoadForm roadForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Spot spot = spotDAO.findById(spotId).get();
        Sector Sector = sectorDAO.findById(sectorId).get();
        Road updateRoad = roadDAO.findById(roadId).get();
        Lenght updateLenght = lenghtDAO.findById(lenghtId).get();
        Scoring updateScoring = scoringDAO.findById(scoringId).get();
        if(roadForm.getRoadName() != null){
            updateRoad.setRoadName(roadForm.getRoadName());
        }
        if(roadForm.getDistance() != null){
            updateLenght.setDistance(roadForm.getDistance());
        }
        if(roadForm.getHeight() != null){
            updateLenght.setHeight(roadForm.getHeight());
        }
        if(roadForm.getRating() != null){
            updateScoring.setRating(roadForm.getRating());
        }
        updateRoad.setClimbUser(climbUser);
        updateLenght.setClimbUser(climbUser);
        updateScoring.setClimbUser(climbUser);
        roadDAO.save(updateRoad);
        lenghtDAO.save(updateLenght);
        scoringDAO.save(updateScoring);
        return "redirect:/spot/{spotId}/sector/{sectorId}/sectorDetails";
    }

    @GetMapping(value = "/spot/{spotId}/sector/{sectorId}/road/{roadId}/lenght/{lenghtId}/scoring/{scoringId}/editRoad")
    public String editSector( @PathVariable Long spotId ,@PathVariable Long sectorId,@PathVariable Long roadId,@PathVariable Long lenghtId,@PathVariable Long scoringId, Model modelSpot, Model modelSector, Model modelRoad,Model modelLenght,Model modelScoring){
        Spot spot = spotDAO.findById(spotId).get();
        modelSpot.addAttribute("spot", spot);
        Sector sector = sectorDAO.findById(sectorId).get();
        modelSector.addAttribute("sector",sector);
        Road road =roadDAO.findById(roadId).get();
        modelRoad.addAttribute("road", road);
        Lenght lenght = lenghtDAO.findByRoadId(roadId);
        modelLenght.addAttribute("lenght",lenght);
        Scoring scoring = scoringDAO.findByRoadId(roadId);
        modelScoring.addAttribute("scoring",scoring);

        return "editRoad";
    }



    @PostMapping("/road/{roadId}/deleteRoad")
    public String deleteRoad (@PathVariable Long roadId) {
        Road road = roadDAO.findById(roadId).get();
        roadDAO.delete(road);
        return "redirect:/espacePerso";
    }
}
