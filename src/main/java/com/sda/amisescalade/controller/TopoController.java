package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.CartographyDAO;
import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.SpotDAO;
import com.sda.amisescalade.dao.TopoDAO;
import com.sda.amisescalade.entities.Cartography;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Controller
public class TopoController {
    @Autowired
    private TopoDAO topoDAO;
    @Autowired
    private ClimbUserDAO climbUserDAO;
    @Autowired
    private SpotDAO spotDAO;
    @Autowired
    private CartographyDAO cartographyDAO;


    /**
     *
     * @param model form
     * @return formTopo
     */
    @RequestMapping(value = "/formTopo")
    public String formTopo(Model model){
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
        Optional<Spot> spotlist = spotDAO.findById(topoform.getSpotId());
        newTopo.setTopoCity(spotlist.get().getCity());
        newTopo.setTopoCountry(spotlist.get().getCountry());
        newTopo.setTopoDepartement(spotlist.get().getDepartment());
        newTopo.setTopoName(topoform.getTopoName());
        newTopo.setRelease(topoform.getRelease());
        newTopo.setAvailable(topoform.isAvailable());
        newTopo.setTopoDescription(topoform.getTopoDescription());
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        newTopo.setClimbUser(climbUser);
        newTopo.setSpot(spotlist.get());
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

    @GetMapping("/editListTopo")
    public String ListupdateTopos(Model modelListEditTopo){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        List<Topo> topoUser = topoDAO.findTopoByClimbUserId(climbUser.getId());
        modelListEditTopo.addAttribute("topoUser", topoUser);
        return "/editListTopo";
    }

    @GetMapping("/topo/{topoId}/editTopo")
    public String getUpdateTopos (@PathVariable Long topoId,Model modelTopo ,Model modelSpot){
        Topo topo = topoDAO.findById(topoId).get();
        modelTopo.addAttribute("topo", topo);
        List<Spot> spotList = spotDAO.findAll();
        modelSpot.addAttribute("spotList", spotList);
        return "/editTopo";
    }

    @PostMapping("/topo/{topoId}/updateTopo")
    public String postUpdateTopos (@PathVariable Long topoId, @ModelAttribute("formTopo") TopoForm topoForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Topo updateTopo = topoDAO.findById(topoId).get();
        if (topoForm.getSpotId()!= null){
            Optional<Cartography> cartography = cartographyDAO.findById(topoForm.getSpotId());
            updateTopo.setTopoCountry(cartography.get().getCountryCartography());
            updateTopo.setTopoDepartement(cartography.get().getDepartmentNameCartography());
            updateTopo.setTopoCity(cartography.get().getCommuneCartography());
        }
        if (topoForm.getTopoName()!= null){
            updateTopo.setTopoName(topoForm.getTopoName());
        }
        if(topoForm.getTopoDescription() != null){
            updateTopo.setTopoDescription(topoForm.getTopoDescription());
        }
        if(topoForm.getRelease() != null){
            updateTopo.setRelease(topoForm.getRelease());
        }
        updateTopo.setClimbUser(climbUser);
        topoDAO.save(updateTopo);

        return "redirect:/espacePerso";
    }

    @GetMapping("/deleteListTopo")
    public String ListdeleteTopos(Model modelListDeleteTopo){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        List<Topo> topoUser = topoDAO.findTopoByClimbUserId(climbUser.getId());
        modelListDeleteTopo.addAttribute("topoUser", topoUser);
        return "/deleteListTopo";
    }

    @PostMapping("/topo/{topoId}/deleteTopo")
    public String deleteTopo (@PathVariable Long topoId) {
        Topo topo = topoDAO.findById(topoId).get();
        topoDAO.delete(topo);
        return "redirect:/espacePerso";
    }
}
