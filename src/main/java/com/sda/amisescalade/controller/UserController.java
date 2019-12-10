package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.*;
import com.sda.amisescalade.dto.TopoForm;
import com.sda.amisescalade.entities.*;
import com.sda.amisescalade.dto.CheckBoxForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Controller
public class UserController {
    @Autowired
    private ClimbUserDAO climbUserDAO;
    @Autowired
    private TopoDAO topoDAO;
    @Autowired
    private SpotDAO spotDAO;
    @Autowired
    private SectorDAO sectorDAO;
    @Autowired
    private RoadDAO roadDAO;
    @Autowired
    private ScoringDAO scoringDAO;
    @Autowired
    private CartographyDAO cartographyDAO;
    @Autowired
    private ReservationDAO reservationDAO;
    /**
     *
     * @return index
     */
    @RequestMapping("/index")
    public String index(Model modelSpotAll, Model modelSectorList, Model modelRoadList, Model modelScoring,Model modelCartoCity,Model modelCartoDepartment,Model modelCartoRegion, Model modelCartoCountry, @RequestParam Optional <String> spotName, Model modelResultSpot,@RequestParam Optional <Long> sectorId, @RequestParam Optional <Long> roadId, @RequestParam Optional<Long> scoringId, @RequestParam Optional<String> cartographyCityName, @RequestParam Optional<String> cartographyDepartementName, @RequestParam Optional<String> cartographyRegionName, @RequestParam Optional<String> cartographyCountryName) {
        List<Spot> spot = spotDAO.findAllSpot();
        modelSpotAll.addAttribute("spot", spot);
        List<Sector> spotBySectors = sectorDAO.findAllSpotBySectors();
        modelSectorList.addAttribute("spotBySectors", spotBySectors);
        List<Road> roads = roadDAO.findDistinctBySector();
        modelRoadList.addAttribute("roads", roads);
        List<Scoring> scorings = scoringDAO.findDistinctByRoad();
        modelScoring.addAttribute("scorings", scorings);
        List<String> cartographyListCity = cartographyDAO.findDistinctByCityCartography();
        modelCartoCity.addAttribute("cartographyListCity", cartographyListCity);
        List<String> cartographyListDepartment = cartographyDAO.findDistinctByDepartmentCartography();
        modelCartoDepartment.addAttribute("cartographyListDepartment", cartographyListDepartment);
        List<String> cartographyListRegion= cartographyDAO.findDistinctByRegionCartography();
        modelCartoRegion.addAttribute("cartographyListRegion", cartographyListRegion);
        List<String> cartographyListCountry = cartographyDAO.findDistinctByCountryCartography();
        modelCartoCountry.addAttribute("cartographyListCountry", cartographyListCountry);
        List<Spot> searchSpot;
        if (spotName.isPresent()) {
            searchSpot = spotDAO.findBySpotName(spotName);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }
        }
        if (sectorId.isPresent()) {
            searchSpot = spotDAO.findById(sectorId);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }

        }
        if (roadId.isPresent()) {
            searchSpot = spotDAO.findById(roadId);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }
        }

        if (scoringId.isPresent()) {
            searchSpot = spotDAO.findById(scoringId);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }

        }
        if (cartographyCityName.isPresent()) {
            searchSpot = spotDAO.findByCartography_CommuneCartography(cartographyCityName);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }

        }
        if (cartographyDepartementName.isPresent()) {
            searchSpot = spotDAO.findByCartography_DepartmentNameCartography(cartographyDepartementName);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }
        }
        if (cartographyRegionName.isPresent()) {
            searchSpot = spotDAO.findByCartography_RegionCartography(cartographyRegionName);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }
        }
        if (cartographyCountryName.isPresent()) {
            searchSpot = spotDAO.findByCartography_CountryCartography(cartographyCountryName);
            if (!searchSpot.isEmpty()) {
                spot.addAll(searchSpot);
                spot = new ArrayList<>();
                modelSpotAll.addAttribute("spot", spot);
                modelResultSpot.addAttribute("searchSpot", searchSpot);
            }
        }
        return "index";
    }

    /**
     *
     * @param modelListTopoUser
     * @param modelListTopo
     * @param modelSpot
     * @param modelReservation
     * @return
     */
    @GetMapping("/espacePerso")
    public String espacePerso(Model modelListTopoUser, Model modelListTopo, Model modelSpot, Model modelReservation, @RequestParam Optional <Long> spotId,@RequestParam Optional<Long> cartographyCityId, Model modelResultTopo) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        List<Topo> topoUser = topoDAO.findTopoByClimbUserId(climbUser.getId());
        modelListTopoUser.addAttribute("topoUser", topoUser);
        List <Topo> searchTopos = topoDAO.findTopoByAvailableTrue();
        modelListTopo.addAttribute("searchTopos", searchTopos);
        List<Spot> searchSpot = spotDAO.findAllSpot();
        modelSpot.addAttribute("searchSpot", searchSpot);
        List <Reservation> reservations = reservationDAO.findReservationsByOwner(climbUser.getUsername());
        modelReservation.addAttribute("reservations",reservations);
        List<Topo> refineSearchTopos;
        if (spotId.isPresent()) {
            refineSearchTopos = topoDAO.findBySpotId(spotId.get());
            if (refineSearchTopos != null) {
                searchTopos.addAll(refineSearchTopos);
                searchTopos = new ArrayList<>();
                modelListTopo.addAttribute("searchTopos",searchTopos);
            }
            modelResultTopo.addAttribute("refineSearchTopos", refineSearchTopos);
        }
        if (cartographyCityId.isPresent()){
            refineSearchTopos = topoDAO.findByCartographyId(cartographyCityId.get());
            if (refineSearchTopos != null) {
                searchTopos.addAll(refineSearchTopos);
                searchTopos = new ArrayList<>();
                modelListTopo.addAttribute("searchTopos",searchTopos);
            }
            modelResultTopo.addAttribute("refineSearchTopos", refineSearchTopos);

        }
        return "espacePerso";
    }

    /**
     *
     * @param topoId
     * @param model
     * @param checkBoxForm
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/topo/{topoId}/availability")
    public String updateAvailabilty(@PathVariable Long topoId, Model model, @ModelAttribute("checkBoxForm") @Validated CheckBoxForm checkBoxForm, BindingResult result, final RedirectAttributes redirectAttributes) {
        Topo topo = topoDAO.findById(topoId).get();
        topo.setAvailable(checkBoxForm.getRealAvailability());
        Reservation reservation = reservationDAO.findReservationsByTopoId(topoId);
        if (topo.isAvailable() && reservation != null){
            reservationDAO.delete(reservation);
            topoDAO.save(topo);
        }else{
            topoDAO.save(topo);}
        return "redirect:/espacePerso";
    }


    /**
     *
     * @param topoId
     * @param model
     * @param topoForm
     * @param result
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/espacePerso#topos/{topoId}/result")
    public String resultSearchTopo(@PathVariable Long topoId, Model model, @ModelAttribute("topoForm") @Validated TopoForm topoForm, BindingResult result, final RedirectAttributes redirectAttributes){
        List<Topo> searchTopos = new ArrayList<>();
        Topo resultTopo = topoDAO.findById(topoId).get();
        resultTopo.setSpot(topoForm.getSpot());
        resultTopo.setTopoName(topoForm.getTopoName());
        resultTopo.setTopoDepartement(topoForm.getTopoDepartement());
        resultTopo.setTopoCountry(topoForm.getTopoCountry());
        searchTopos.add(resultTopo);
        model.addAttribute("searchTopos",searchTopos);
        return "redirect:/espacePerso#topos";
    }


}
