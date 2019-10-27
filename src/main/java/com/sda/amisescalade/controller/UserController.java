package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.SpotDAO;
import com.sda.amisescalade.dao.TopoDAO;
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

import java.util.List;


@Controller
public class UserController {
    @Autowired
    private ClimbUserDAO climbUserDAO;
    @Autowired
    private TopoDAO topoDAO;
    @Autowired
    private SpotDAO spotDAO;
    /**
     *
     * @return index
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     *
     * @return espacePerso
     */
       @GetMapping("/espacePerso")
       public String espacePerso(Model model, Model model2) {
           UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
           ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
           List<Topo> topoUser = topoDAO.findTopoByClimbUserId(climbUser.getId());
           model.addAttribute("topoUser", topoUser);
           List <Topo> searchTopos = topoDAO.findTopoByAvailableTrue();
           model2.addAttribute("searchTopos", searchTopos);
           return "espacePerso";
       }

    @PostMapping("/topo/{topoId}/availability")
    public String updateAvailabilty(@PathVariable Long topoId, Model model, @ModelAttribute("checkBoxForm") @Validated CheckBoxForm checkBoxForm, BindingResult result, final RedirectAttributes redirectAttributes) {
            Topo topo = topoDAO.findById(topoId).get();
            topo.setAvailable(checkBoxForm.getRealAvailability());
            topoDAO.save(topo);
            return "redirect:/espacePerso";
        }


}
