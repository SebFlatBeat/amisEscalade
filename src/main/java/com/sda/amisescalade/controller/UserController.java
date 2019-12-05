package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.ReservationDAO;
import com.sda.amisescalade.dao.SpotDAO;
import com.sda.amisescalade.dao.TopoDAO;
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private ReservationDAO reservationDAO;
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
     * @param modelListTopoUser
     * @param modelListTopo
     * @param modelSpot
     * @param modelReservation
     * @return
     */
       @RequestMapping(value = {"/espacePerso#topos", "/espacePerso"})
       public String espacePerso(Model modelListTopoUser, Model modelListTopo, Model modelSpot, Model modelReservation, @RequestParam Optional <Long> spotId, Model modelResultTopo) {
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
           if (spotId.isPresent()) {
               List<Topo> refineSearchTopos = topoDAO.findBySpotId(spotId.get());
               if (refineSearchTopos != null) {
                   searchTopos.addAll(refineSearchTopos);
               }
               modelResultTopo.addAttribute("refineSearchTopos", refineSearchTopos);
               searchTopos = new ArrayList<>();
               modelListTopo.addAttribute("searchTopos",searchTopos);
               return "espacePerso#topos";
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
