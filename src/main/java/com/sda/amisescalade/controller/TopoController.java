package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.SpotDAO;
import com.sda.amisescalade.dao.TopoDAO;
import com.sda.amisescalade.entities.ClimbUser;
import com.sda.amisescalade.entities.Spot;
import com.sda.amisescalade.entities.Topo;
import com.sda.amisescalade.dto.TopoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TopoController {
    @Autowired
    private TopoDAO topoDAO;
    @Autowired
    private ClimbUserDAO climbUserDAO;
    @Autowired
    private SpotDAO spotDAO;


    /**
     *
     * @param model form
     * @return formTopo
     */
    @RequestMapping(value = "/formTopo")
    public String form(Model model){
        List<Spot> spotList = spotDAO.findAll();
        model.addAttribute("spotList", spotList);
        return "formTopo";
    }
    /**
     *
     * @param model
     * @param topoform
     * @param result
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/saveFormTopo")
    public String saveFormTopo (Model model, @ModelAttribute("topoForm") @Validated TopoForm topoform,BindingResult result, final RedirectAttributes redirectAttributes) {

        Topo newTopo = new Topo();
        newTopo.setTopoCity(topoform.getTopoCity());
        newTopo.setTopoCountry(topoform.getTopoCountry());
        newTopo.setTopoDepartement(topoform.getTopoDepartement());
        newTopo.setTopoName(topoform.getTopoName());
        newTopo.setRelease(topoform.getRelease());
        newTopo.setAvailable(topoform.isAvailable());
        newTopo.setTopoDescription(topoform.getTopoDescription());
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        newTopo.setClimbUser(climbUser);
        Spot spot = new Spot();
        spot = spotDAO.findBySpotName(spot.getSpotName());
        newTopo.setSpot(spot);

        try{
            topoDAO.save(newTopo);
        }
        catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/index";
        }
        redirectAttributes.addFlashAttribute("flashTopo", newTopo);
        return "redirect:/espacePerso";
    }
}
