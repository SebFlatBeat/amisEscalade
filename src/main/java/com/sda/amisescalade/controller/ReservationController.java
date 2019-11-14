package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.ReservationDAO;
import com.sda.amisescalade.dao.TopoDAO;
import com.sda.amisescalade.dto.CheckBoxForm;
import com.sda.amisescalade.dto.ReservationForm;
import com.sda.amisescalade.entities.ClimbUser;
import com.sda.amisescalade.entities.Reservation;
import com.sda.amisescalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController {
    @Autowired
    ReservationDAO reservationDAO;
    @Autowired
    private ClimbUserDAO climbUserDAO;
    @Autowired
    private TopoDAO topoDAO;

    /**
     *
     * @param model
     * @param reservationForm
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/saveReservation")
    public String createReservation(Model model, @ModelAttribute("reservationForm")ReservationForm reservationForm, BindingResult result, final RedirectAttributes redirectAttributes){
        Reservation newReservation = new Reservation();
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        newReservation.setBorrowing(date);
        newReservation.setBorrower(climbUser.getUsername());
        newReservation.setTopoNameReservation(reservationForm.getTopoNameReservation());
        newReservation.setOwner(reservationForm.getOwner());
        Optional<Topo> topo = topoDAO.findById(reservationForm.getTopoId());
        newReservation.setTopo(topo.get());
        Optional<ClimbUser> climbUserOwner = climbUserDAO.findById(reservationForm.getOwnerId());
        newReservation.setClimbUser(climbUserOwner.get());
        model.addAttribute("newReservation", newReservation);
        try{
            reservationDAO.save(newReservation);
        }catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/index";
        }
        return "redirect:/espacePerso#topos";
    }

    /**
     *
     * @param reservationId
     * @param model
     * @param checkBoxForm
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/reservation/{reservationId}/accepted")
    public String updateAccepted(@PathVariable Long reservationId, Model model, @ModelAttribute("checkBoxForm") @Validated CheckBoxForm checkBoxForm, BindingResult result, final RedirectAttributes redirectAttributes) {
        Reservation reservation = reservationDAO.findById(reservationId).get();
        reservation.setAccepted(checkBoxForm.getRealAvailability());
        Topo topo = topoDAO.findById(reservation.getTopo().getId()).get();
        topo.setAvailable(checkBoxForm.getRealAccepted());
        topoDAO.save(topo);
        if (reservation.isAccepted()){
        reservationDAO.save(reservation);
        }else{
            reservationDAO.delete(reservation);
        }
        return "redirect:/espacePerso#demandes";
    }
}
