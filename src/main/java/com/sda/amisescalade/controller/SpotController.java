package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.CartographyDAO;
import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.SpotDAO;
import com.sda.amisescalade.dao.TopoDAO;
import com.sda.amisescalade.dto.SpotForm;
import com.sda.amisescalade.entities.Cartography;
import com.sda.amisescalade.entities.ClimbUser;
import com.sda.amisescalade.entities.Spot;
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
    ClimbUserDAO climbUserDAO;

    @Autowired
    TopoDAO topoDAO;

    @Autowired
    SpotDAO spotDAO;

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

}
