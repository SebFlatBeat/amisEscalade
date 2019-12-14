package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.*;
import com.sda.amisescalade.dto.SpotForm;
import com.sda.amisescalade.entities.*;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
public class SpotController {

    @Autowired
    private CartographyDAO cartographyDAO;

    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Autowired
    private SpotDAO spotDAO;

    @Autowired
    private SectorDAO sectorDAO;

    @Autowired
    private CommentSpotDAO commentSpotDAO;

    /**
     *
     * @param modelCity
     * @return
     */
    @GetMapping(value = "/formSpot")
    public String formSpot(Model modelCity){
        List<Cartography> cartographyListCity = cartographyDAO.findAllCity();
        modelCity.addAttribute("cartographyListCity", cartographyListCity);
        return "/formSpot";
    }


    @PostMapping(value = "/saveFormSpot")
    public String saveNewSpot(Model model, @ModelAttribute("formSpot") SpotForm spotForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Spot newSpot = new Spot();
        Optional<Cartography> cartography = cartographyDAO.findById(spotForm.getSpotNameId());
        newSpot.setCartography(cartography.get());
        newSpot.setCity(cartography.get().getCommuneCartography(), cartography.get().getCodePostalCartography());
        newSpot.setClimbUser(climbUser);
        newSpot.setCountry(cartography.get().getCountryCartography());
        newSpot.setDepartment(cartography.get().getDepartmentNameCartography(), cartography.get().getDepartmentCartography());
        newSpot.setRegion(cartography.get().getRegionCartography());
        newSpot.setSpotName(spotForm.getSpotName());
        newSpot.setTag(spotForm.isTag());
        spotDAO.save(newSpot);
        return "redirect:/espacePerso";
    }

    @GetMapping(value = "/spot/{spotId}/editSpot")
    public String updateSpot (@PathVariable Long spotId, Model model, Model modelCity){
        Spot spot = spotDAO.findById(spotId).get();
        model.addAttribute("spot", spot);
        List<Cartography> cartographyListCity = cartographyDAO.findAllCity();
        modelCity.addAttribute("cartographyListCity", cartographyListCity);
        return "/editSpot";
    }
    @PostMapping(value = "/spot/{spotId}/updateFormSpot")
    public String updateSpot(@PathVariable Long spotId,Model model, @ModelAttribute("formSpot") SpotForm spotForm, BindingResult result, final RedirectAttributes redirectAttributes) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Spot updateSpot = spotDAO.findById(spotId).get();
        if (spotForm.getSpotNameId() != null) {
            Optional<Cartography> cartography = cartographyDAO.findById(spotForm.getSpotNameId());
            updateSpot.setCartography(cartography.get());
            updateSpot.setCity(cartography.get().getCommuneCartography(), cartography.get().getCodePostalCartography());
            updateSpot.setCountry(cartography.get().getCountryCartography());
            updateSpot.setDepartment(cartography.get().getDepartmentNameCartography(), cartography.get().getDepartmentCartography());
            updateSpot.setRegion(cartography.get().getRegionCartography());
        }
        if(spotForm.getSpotName() != null){
            updateSpot.setSpotName(spotForm.getSpotName());
        }
        updateSpot.setClimbUser(climbUser);
        updateSpot.setTag(spotForm.isTag());
        spotDAO.save(updateSpot);
        return "redirect:/spot/{spotId}/spotDetails";
    }

    @GetMapping(value = "/spot/{spotId}/spotDetails")
    public String spotDetail(@PathVariable Long spotId, Model modelSpot, Model modelSector, Model modelSpotComment, Model modelClimbUser){
        UserDetails user = null;
        ClimbUser climbUser = new ClimbUser();
        climbUser.setId(0L);
        try{
            user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch(ClassCastException e) {

        }
        if (user != null) {
          climbUser  = climbUserDAO.findClimbUserByUserName(user.getUsername());
        }
        modelClimbUser.addAttribute("climbUser", climbUser);
        Spot spotDetails = spotDAO.findById(spotId).get();
        modelSpot.addAttribute("spotDetails", spotDetails);
        List<Sector> sectorList = sectorDAO.findSectorsBySpotId(spotId);
        modelSector.addAttribute("sectorList",sectorList);
        List<CommentSpot> commentSpots = commentSpotDAO.findBySpotId(spotId);
        modelSpotComment.addAttribute("commentSpots", commentSpots);
        return "/detailSpot";
    }

    @PostMapping("/spot/{spotId}/deleteSpot")
    public String deleteSpot (@PathVariable Long spotId) {
        Spot spot = spotDAO.findById(spotId).get();
        spotDAO.delete(spot);
        return "redirect:/espacePerso#spots";
    }
}
