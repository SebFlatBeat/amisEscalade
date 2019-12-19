package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.*;
import com.sda.amisescalade.dto.TopoForm;
import com.sda.amisescalade.entities.*;
import com.sda.amisescalade.dto.CheckBoxForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import java.util.stream.Collectors;


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
     * @param modelSpotAll
     * @param modelSearchSpot
     * @param modelSectorList
     * @param modelSectorNameList
     * @param modelRoadList
     * @param modelScoring
     * @param modelCartoCity
     * @param modelCartoDepartment
     * @param modelCartoRegion
     * @param modelCartoCountry
     * @param spotId
     * @param sectorNumber
     * @param roadNumber
     * @param scoringString
     * @param cartographyCityName
     * @param cartographyDepartementName
     * @param cartographyRegionName
     * @param cartographyCountryName
     * @return
     */
    @RequestMapping("/index")
    public String index(Model modelSpotAll, Model modelSearchSpot, Model modelSectorList,Model modelSectorNameList, Model modelRoadList, Model modelScoring,Model modelCartoCity,Model modelCartoDepartment,Model modelCartoRegion, Model modelCartoCountry, @RequestParam Optional <Long> spotId,@RequestParam Optional <Long> sectorNumber, @RequestParam Optional <Long> roadNumber, @RequestParam Optional<String> scoringString, @RequestParam Optional<String> cartographyCityName, @RequestParam Optional<String> cartographyDepartementName, @RequestParam Optional<String> cartographyRegionName, @RequestParam Optional<String> cartographyCountryName) {
        List<Spot> spot = spotDAO.findAll();
        modelSpotAll.addAttribute("spot", spot);
        List<Long> spotBySectors = sectorDAO.findNumberOfSector();
        modelSectorList.addAttribute("spotBySectors", spotBySectors);
        List<Sector> sectorName = sectorDAO.findAllSpotBySectors();
        modelSectorNameList.addAttribute("sectorName",sectorName);
        List<Long> roads = roadDAO.findNumberOfRoad();
        modelRoadList.addAttribute("roads", roads);
        List<String> scorings = scoringDAO.findDistinctByRoad();
        modelScoring.addAttribute("scorings", scorings);
        List<String> cartographyListCity = cartographyDAO.findDistinctByCityCartography();
        modelCartoCity.addAttribute("cartographyListCity", cartographyListCity);
        List<String> cartographyListDepartment = cartographyDAO.findDistinctByDepartmentCartography();
        modelCartoDepartment.addAttribute("cartographyListDepartment", cartographyListDepartment);
        List<String> cartographyListRegion= cartographyDAO.findDistinctByRegionCartography();
        modelCartoRegion.addAttribute("cartographyListRegion", cartographyListRegion);
        List<String> cartographyListCountry = cartographyDAO.findDistinctByCountryCartography();
        modelCartoCountry.addAttribute("cartographyListCountry", cartographyListCountry);
        List<Spot>searchSpot = spotDAO.findAll();
        if (spotId.isPresent() && !searchSpot.isEmpty()) {
            searchSpot = spotDAO.findBySpotIdInList(spotId.get(), searchSpot);
        }
        if (sectorNumber.isPresent() && !searchSpot.isEmpty()) {
            List<Long[]> sector = spotDAO.findByNumberOfSectorInList(searchSpot);
            sector =sector.stream().filter(element -> element[1] == sectorNumber.get()).collect(Collectors.toList());
            List<Long> spotIds = sector.stream().map(element -> element[0]).collect(Collectors.toList());
            searchSpot = spotDAO.findAllById(spotIds);
        }
        if (roadNumber.isPresent() && !searchSpot.isEmpty()) {
            List<Long[]> road = spotDAO.findByNumberOfRoadInList(searchSpot);
            road = road.stream().filter(element -> element[1] == roadNumber.get()).collect(Collectors.toList());
            List<Long> spotIds = road.stream().map(element -> element[0]).collect(Collectors.toList());
            searchSpot = spotDAO.findAllById(spotIds);
        }
        if(scoringString.isPresent() && scoringString.get().isEmpty() && !searchSpot.isEmpty()){
            searchSpot = spotDAO.findByScoringInList(scoringString.get(),searchSpot);
        }
        if(cartographyCityName.isPresent() && !cartographyCityName.get().isEmpty() && !searchSpot.isEmpty()){
            searchSpot = spotDAO.findByCartographyCityInList(cartographyCityName.get(),searchSpot);
        }
        if(cartographyDepartementName.isPresent() && !cartographyDepartementName.get().isEmpty() && !searchSpot.isEmpty()){
            searchSpot = spotDAO.findByCartographyDepartmentInList(cartographyDepartementName.get(),searchSpot);
        }
        if(cartographyRegionName.isPresent() && !cartographyRegionName.get().isEmpty() && !searchSpot.isEmpty()){
            searchSpot = spotDAO.findByCartographyRegionInList(cartographyRegionName.get(),searchSpot);
        }
        if(cartographyCountryName.isPresent() && !cartographyCountryName.get().isEmpty() && !searchSpot.isEmpty()){
            searchSpot = spotDAO.findByCartographyCountryInList(cartographyCountryName.get(),searchSpot);
        }
        modelSearchSpot.addAttribute("searchSpot", searchSpot);

        return "index";
    }

    /**
     *
     * @param modelListTopoUser
     * @param modelSpot
     * @param modelPages
     * @param modelSize
     * @param modelReservation
     * @param spotId
     * @param cartographyCityName
     * @param cartographyDepartementName
     * @param cartographyRegionName
     * @param cartographyCountryName
     * @param modelResultTopo
     * @param modelClimbUser
     * @param modelCartoCity
     * @param modelCartoDepartment
     * @param modelCartoRegion
     * @param modelCartoCountry
     * @return
     */
    @GetMapping("/espacePerso")
    public String espacePerso(Model modelListTopoUser, Model modelSpot, Model modelPages,Model modelSize, Model modelReservation, @RequestParam Optional <Long> spotId,  @RequestParam Optional<String> cartographyCityName, @RequestParam Optional<String> cartographyDepartementName, @RequestParam Optional<String> cartographyRegionName, @RequestParam Optional<String> cartographyCountryName, Model modelResultTopo, Model modelClimbUser,Model modelCartoCity,Model modelCartoDepartment,Model modelCartoRegion, Model modelCartoCountry) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        modelClimbUser.addAttribute("climbUser", climbUser);
        List<Topo> topoUser = topoDAO.findTopoByClimbUserId(climbUser.getId());
        modelListTopoUser.addAttribute("topoUser", topoUser);
        Pageable firstPage = PageRequest.of(0,7, Sort.by("spotName"));
        List<Spot> searchSpot = spotDAO.findAllSpot(firstPage);
        modelSpot.addAttribute("searchSpot", searchSpot);
        int[] pages = new int[firstPage.getPageNumber()];
        modelPages.addAttribute("pages",pages);
        int[] size = new int[firstPage.getPageSize()];
        modelSize.addAttribute("size", size);
        List <Reservation> reservations = reservationDAO.findReservationsByOwner(climbUser.getUsername());
        modelReservation.addAttribute("reservations",reservations);
        List<String> cartographyListCity = cartographyDAO.findDistinctByCityCartography();
        modelCartoCity.addAttribute("cartographyListCity", cartographyListCity);
        List<String> cartographyListDepartment = cartographyDAO.findDistinctByDepartmentCartography();
        modelCartoDepartment.addAttribute("cartographyListDepartment", cartographyListDepartment);
        List<String> cartographyListRegion= cartographyDAO.findDistinctByRegionCartography();
        modelCartoRegion.addAttribute("cartographyListRegion", cartographyListRegion);
        List<String> cartographyListCountry = cartographyDAO.findDistinctByCountryCartography();
        modelCartoCountry.addAttribute("cartographyListCountry", cartographyListCountry);
        List <Topo> searchTopos = topoDAO.findTopoByAvailableTrue();
        if (spotId.isPresent() && !searchTopos.isEmpty()) {
            searchTopos = topoDAO.findBySpotIdInList(spotId.get(),searchTopos);
        }
        if(cartographyCityName.isPresent() && !cartographyCityName.get().isEmpty() && !searchTopos.isEmpty()){
            searchTopos = topoDAO.findByCartographyCityInList(cartographyCityName.get(),searchTopos);
        }
        if(cartographyDepartementName.isPresent() && !cartographyDepartementName.get().isEmpty() && !searchTopos.isEmpty()){
            searchTopos = topoDAO.findByCartographyDepartmentInList(cartographyDepartementName.get(),searchTopos);
        }
        if(cartographyRegionName.isPresent() && !cartographyRegionName.get().isEmpty() && !searchTopos.isEmpty()){
            searchTopos = topoDAO.findByCartographyRegionInList(cartographyRegionName.get(),searchTopos);
        }
        if(cartographyCountryName.isPresent() && !cartographyCountryName.get().isEmpty() && !searchTopos.isEmpty()) {
            searchTopos = topoDAO.findByCartographyCountryInList(cartographyCountryName.get(), searchTopos);
        }
        modelResultTopo.addAttribute("searchTopos", searchTopos);
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

    /**
     *
     * @return
     */
    @RequestMapping(value = "/403")
    public String accessDenied(){
        return "403";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/500")
    public String accessError(){
        return "500";
    }


}
