package com.sda.amisescalade.controller;

import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dto.ClimbUserForm;
import com.sda.amisescalade.entities.ClimbUser;
import com.sda.amisescalade.entities.ClimbUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClimbUserDAO climbUserDAO;

    @Autowired
    private ClimbUserValidator climbUserValidator;

    /**
     *
     * @param dataBinder
     */
    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        // Form target
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == ClimbUserForm.class) {
            dataBinder.setValidator(climbUserValidator);
        }

    }

    /**
     *
     * @param model viewHome
     * @return index
     */
    @RequestMapping("/")
    public String viewHome(Model model) {

        return "index";
    }


    /**
     *
     * @param model viwMembers
     * @return membersPage
     */
    @RequestMapping("/members")
    public String viewMembers(Model model) {
        Iterable<ClimbUser> iterable = climbUserDAO.findAll();
        model.addAttribute("members", iterable);

        return "membersPage";
    }

    /**
     *
     * @param model viewRegisterSuccessful
     * @return registerSuccessfulPage
     */
    @RequestMapping("/registerSuccessfulPage")
    public String viewRegisterSuccessful(Model model) {

        return "registerSuccessfulPage";
    }

    /**
     *
     * @param model viewRegister
     * @return registerPage
     */
    // Show Register page.
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(Model model) {

        ClimbUserForm form = new ClimbUserForm();
        model.addAttribute("climbUserForm", form);
        return "registerPage";
    }

    /**
     *
     * @param model
     * @param climbUserForm
     * @param result
     * @param redirectAttributes
     * @return
     */
    // This method is called to save the registration information.
    // @Validated: To ensure that this Form
    // has been Validated before this method is invoked.
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(Model model, @ModelAttribute("climbUserForm") ClimbUserForm climbUserForm, BindingResult result, final RedirectAttributes redirectAttributes) {

        // Validate result
        climbUserValidator.validate(climbUserForm, result);
        if (result.hasErrors()){
            return "registerPage";
        }else {
            ClimbUser newUser = new ClimbUser();
            newUser.setUserName(climbUserForm.getUserName());
            newUser.setPassword(passwordEncoder.encode(climbUserForm.getPassword()));
            newUser.setEmail(climbUserForm.getEmail());
            try {
                //newUser = climbUserDAO.createClimbUser(climbUserForm);
                climbUserDAO.save(newUser);
            }
            // Other error!!
            catch (Exception e) {
                model.addAttribute("errorMessage", "Error: " + e.getMessage());
                return "registerPage";
            }

            redirectAttributes.addFlashAttribute("flashUser", newUser);

            return "redirect:/registerSuccessfulPage";
        }
    }


}

