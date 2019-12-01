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

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SectorController {

    @Autowired
    ClimbUserDAO climbUserDAO;

    @Autowired
    RoadDAO roadDAO;

    @Autowired
    SpotDAO spotDAO;

    @Autowired
    SectorDAO sectorDAO;

    @Autowired
    LenghtDAO lenghtDAO;

    @Autowired
    ScoringDAO scoringDAO;

    @GetMapping(value = "spot/{spotId}/sectorForm")
    public String getFormSector(@PathVariable Long spotId) {
        return "/formSector";
    }

    @PostMapping(value = "spot/{spotId}/sectorForm")
    public String saveFormSector(@PathVariable Long spotId, Model model, @ModelAttribute("sectorForm") @Validated SectorForm sectorForm, BindingResult result, final RedirectAttributes redirectAttributes){
        Spot spot = spotDAO.findById(spotId).get();
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Sector sector = new Sector();
        sector.setClimbUser(climbUser);
        sector.setSpot(spot);
        sector.setSectorName(sectorForm.getSectorName());
        sector.setAccess(sectorForm.getAccess());
        sector.setLocation(sectorForm.getLocation());
        sectorDAO.save(sector);
        Road road = new Road();
        road.setClimbUser(climbUser);
        road.setSector(sector);
        road.setRoadName(sectorForm.getRoadName());
        roadDAO.save(road);
        Lenght lenght = new Lenght();
        lenght.setClimbUser(climbUser);
        lenght.setDistance(sectorForm.getDistance());
        lenght.setHeight(sectorForm.getHeight());
        lenghtDAO.save(lenght);
        Scoring scoring = new Scoring();
        scoring.setClimbUser(climbUser);
        scoring.setRoad(road);
        scoring.setLenght(lenght);
        scoring.setRating(sectorForm.getRating());
        scoringDAO.save(scoring);
        return "redirect:/espacePerso";
    }

    @GetMapping(value = "/sector/{sectorId}/updateSector")
    public String updateSector( @PathVariable Long sectorId){

        Sector sector = sectorDAO.findById(sectorId).get();
        return "editSector";
    }

    @GetMapping(value = "/spot/{spotId}/sector/{sectorId}/sectorDetails")
    public String sectorDetail(@PathVariable Long spotId,@PathVariable Long sectorId, Model modelSpot, Model modelSector, Model modelRoad, Model modelLenght){
        Spot spot = spotDAO.findById(spotId).get();
        modelSpot.addAttribute("spot",spot);
        Sector sectorDetails = sectorDAO.findById(sectorId).get();
        modelSector.addAttribute("sectorDetails", sectorDetails);
        List <Road> roadList = roadDAO.findRoadsBySectorId(sectorId);
        modelRoad.addAttribute("roadList",roadList);
        List <Lenght> lenghtList = lenghtDAO.findLenghtBySectorId(sectorId);
        modelLenght.addAttribute("lenghtList", lenghtList);
        return "/detailSector";
    }

    @PostMapping("/sector/{sectorId}/deleteSector")
    public String deleteSector (@PathVariable Long sectorId) {
        Sector sector = sectorDAO.findById(sectorId).get();
        sectorDAO.delete(sector);
        return "redirect:/espacePerso";
    }
}
