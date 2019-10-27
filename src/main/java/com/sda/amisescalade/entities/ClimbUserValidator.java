package com.sda.amisescalade.entities;


import com.sda.amisescalade.dao.ClimbUserDAO;
import com.sda.amisescalade.dto.ClimbUserForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClimbUserValidator implements Validator {

    // common-validator library.
    private EmailValidator emailValidator=EmailValidator.getInstance();

    @Autowired
    private ClimbUserDAO climbUserDAO;

    // The classes are supported by this validator.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == ClimbUserForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {

        ClimbUserForm climbUserForm = (ClimbUserForm) target;

        // Check the fields of ClimbUserForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.climUserForm.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.climUserForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.climUserForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.climUserForm.confirmPassword");

        if(!this.emailValidator.isValid(climbUserForm.getEmail())) {
            //Invalid email.
            errors.rejectValue("email", "Pattern.climUserForm.email");
        }else if (climbUserForm.getId() == null){
                ClimbUser dbUser = climbUserDAO.findClimbUserByEmail(climbUserForm.getEmail());
            if (dbUser != null){
                //Email has been used by another account.
                errors.rejectValue("email", "Duplicate.climbUserForm.email");
            }
        }

        if (!errors.hasFieldErrors("userName")){
            ClimbUser dbUser = climbUserDAO.findClimbUserByUserName(climbUserForm.getUserName());
            if(dbUser != null){
                //Username is not available
                errors.rejectValue("userName","Duplicate.climbUserForm.userName");
            }
        }

        if(!errors.hasErrors()){
            if(!climbUserForm.getConfirmPassword().equals(climbUserForm.getPassword())){
                errors.rejectValue("confirmPassword", "Match.climbUserForm.confirmPassword");
            }
        }

    }
}
