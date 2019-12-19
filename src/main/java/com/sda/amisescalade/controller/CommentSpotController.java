package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dao.CommentSpotDAO;
import com.sda.amisescalade.dao.SpotDAO;
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
public class CommentSpotController {
    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Autowired
    private SpotDAO spotDAO;

    @Autowired
    private CommentSpotDAO commentSpotDAO;

    /**
     *
     * @param spotId
     * @param model
     * @param commentForm
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/spot/{spotId}/saveCommentSpot")
    public String saveCommentSpot(@PathVariable Long spotId, Model model, @ModelAttribute("commentForm") CommentForm commentForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Optional<Spot> spot =spotDAO.findById(spotId);
        CommentSpot newCommentSpot = new CommentSpot();
        newCommentSpot.setClimbUser(climbUser);
        newCommentSpot.setSpot(spot.get());
        newCommentSpot.setTexteComment(commentForm.getTexteComment());
        newCommentSpot.setDate(commentForm.getDate());
        commentSpotDAO.save(newCommentSpot);
        return "redirect:/spot/{spotId}/spotDetails";
    }

    /**
     *
     * @param spotId
     * @param commentSpotId
     * @param model
     * @param commentForm
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/spot/{spotId}/updateCommentSpot/{commentSpotId}")
    public String updateCommentSpot(@PathVariable Long spotId, @PathVariable Long commentSpotId, Model model, @ModelAttribute("commentForm") CommentForm commentForm, BindingResult result, final RedirectAttributes redirectAttributes){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClimbUser climbUser = climbUserDAO.findClimbUserByUserName(user.getUsername());
        Spot spot =spotDAO.findById(spotId).get();
        CommentSpot updateCommentSpot = commentSpotDAO.findById(commentSpotId).get();
        if (commentForm.getTexteComment() != null){
            updateCommentSpot.setTexteComment(commentForm.getTexteComment());
            updateCommentSpot.setDate(commentForm.getDate());
            updateCommentSpot.setClimbUser(climbUser);
        }
        commentSpotDAO.save(updateCommentSpot);

        return "redirect:/spot/{spotId}/spotDetails";
    }

    /**
     *
     * @param spotId
     * @param commentSpotId
     * @return
     */
    @PostMapping("spot/{spotId}/deleteCommentSpot/{commentSpotId}")
    public String deleteCommentSector (@PathVariable Long spotId, @PathVariable Long commentSpotId) {
        Spot spot = spotDAO.findById(spotId).get();
        CommentSpot commentSpot = commentSpotDAO.findById(commentSpotId).get();
        commentSpotDAO.delete(commentSpot);
        return "redirect:/spot/{spotId}/spotDetails";
    }

}
