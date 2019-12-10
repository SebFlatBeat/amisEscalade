package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.*;
import com.sda.amisescalade.dto.SectorForm;
import com.sda.amisescalade.dto.SpotForm;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SectorController {

    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Autowired
    private RoadDAO roadDAO;

    @Autowired
    private SpotDAO spotDAO;

    @Autowired
    private SectorDAO sectorDAO;

    @Autowired
    private LenghtDAO lenghtDAO;

    @Autowired
    private ScoringDAO scoringDAO;

    @Autowired
    private CommentSectorDAO commentSectorDAO;

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
        return "redirect:/espacePerso#spots";
    }

    @GetMapping(value = "/spot/{spotId}/sector/{sectorId}/editSector")
    public String editSector( @PathVariable Long spotId ,@PathVariable Long sectorId, Model modelSpot, Model modelSector){
        Spot spot = spotDAO.findById(spotId).get();
        modelSpot.addAttribute("spot", spot);
        Sector sector = sectorDAO.findById(sectorId).get();
        modelSector.addAttribute("sector",sector);
        return "editSector";
    }

    @PostMapping(value = "/spot/{spotId}/sector/{sectorId}/updateFormSector")
    public String updateSector(@PathVariable Long spotId, @PathVariable Long sectorId,Model model, @ModelAttribute("formSector") SectorForm sectorForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Spot spot = spotDAO.findById(spotId).get();
        Sector updateSector = sectorDAO.findById(sectorId).get();
        if(sectorForm.getSectorName() != null){
            updateSector.setSectorName(sectorForm.getSectorName());
        }
        if(sectorForm.getLocation() != null){
            updateSector.setLocation(sectorForm.getLocation());
        }
        if(sectorForm.getAccess() != null){
            updateSector.setAccess(sectorForm.getAccess());
        }
        updateSector.setClimbUser(climbUser);
        sectorDAO.save(updateSector);
        return "redirect:/spot/{spotId}/sector/{sectorId}/sectorDetails)";
    }

    @GetMapping(value = "/spot/{spotId}/sector/{sectorId}/sectorDetails")
    public String sectorDetail(@PathVariable Long spotId,@PathVariable Long sectorId, Model modelSpot, Model modelSector, Model modelRoad, Model modelLenght, Model modelCommentSector, Model modelScoring){
        Spot spot = spotDAO.findById(spotId).get();
        modelSpot.addAttribute("spot",spot);
        Sector sectorDetails = sectorDAO.findById(sectorId).get();
        modelSector.addAttribute("sectorDetails", sectorDetails);
        List <Road> roadList = roadDAO.findRoadsBySectorId(sectorId);
        modelRoad.addAttribute("roadList",roadList);
        List <Lenght> lenghtList = lenghtDAO.findLenghtBySectorId(sectorId);
        modelLenght.addAttribute("lenghtList", lenghtList);
        List<CommentSector> commentSectors = commentSectorDAO.findBySectorId(sectorId);
        modelCommentSector.addAttribute("commentSectors", commentSectors);
        List<Scoring> scoringList = scoringDAO.findScoringBySectorId(sectorId);
        modelScoring.addAttribute("scoringList",scoringList);
        return "/detailSector";
    }

    @PostMapping("spot/{spotId}/sector/{sectorId}/deleteSector")
    public String deleteSector (@PathVariable Long sectorId, @PathVariable Long spotId) {
        Spot spot = spotDAO.findById(spotId).get();
        Sector sector = sectorDAO.findById(sectorId).get();
        sectorDAO.delete(sector);
        return "redirect:/spot/{spotId}/spotDetails";
    }
}
