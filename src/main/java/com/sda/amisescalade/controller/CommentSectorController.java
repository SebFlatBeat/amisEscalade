package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.*;
import com.sda.amisescalade.dto.CommentForm;
import com.sda.amisescalade.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CommentSectorController {
    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Autowired
    private SpotDAO spotDAO;

    @Autowired
    private SectorDAO sectorDAO;

    @Autowired
    private CommentSectorDAO commentSectorDAO;

    @PostMapping("/spot/{spotId}/sector/{sectorId}/saveCommentSector")
    public String saveCommentSector(@PathVariable Long spotId, @PathVariable Long sectorId, Model model, @ModelAttribute("commentForm") CommentForm commentForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Optional<Spot> spot = spotDAO.findById(spotId);
        Optional<Sector> sector = sectorDAO.findById(sectorId);
        CommentSector newCommentSector = new CommentSector();
        newCommentSector.setClimbUser(climbUser);
        newCommentSector.setSector(sector.get());
        newCommentSector.setTexteComment(commentForm.getTexteComment());
        newCommentSector.setDate(commentForm.getDate());
        commentSectorDAO.save(newCommentSector);
        return "redirect:/spot/{spotId}/sector/{sectorId}/sectorDetails";
    }

    @PostMapping("/spot/{spotId}/sector/{sectorId}/updateCommentSector/{commentSectorId}")
    public String updateCommentSpot(@PathVariable Long spotId, @PathVariable Long sectorId,@PathVariable Long commentSectorId , Model model, @ModelAttribute("commentForm") CommentForm commentForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Spot spot = spotDAO.findById(spotId).get();
        Sector sector = sectorDAO.findById(sectorId).get();
        CommentSector updateCommentSector = commentSectorDAO.findById(commentSectorId).get();
        if (commentForm.getTexteComment() != null){
            updateCommentSector.setTexteComment(commentForm.getTexteComment());
            updateCommentSector.setDate(commentForm.getDate());
            updateCommentSector.setClimbUser(climbUser);
        }
        commentSectorDAO.save(updateCommentSector);
        return "redirect:/spot/{spotId}/sector/{sectorId}/sectorDetails";
    }

    @PostMapping("spot/{spotId}/sector/{sectorId}/deleteCommentSector/{commentSectorId}")
    public String deleteCommentSector (@PathVariable Long sectorId, @PathVariable Long spotId, @PathVariable Long commentSectorId) {
        Spot spot = spotDAO.findById(spotId).get();
        Sector sector = sectorDAO.findById(sectorId).get();
        CommentSector commentSector = commentSectorDAO.findById(commentSectorId).get();
        commentSectorDAO.delete(commentSector);
        return "redirect:/spot/{spotId}/sector/{sectorId}/sectorDetails";
    }
}
