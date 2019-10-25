package com.sda.amisescalade.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class SecurityController {
    /**
     *
     * @return index
     */
    @RequestMapping("/login?logout")
    public String logout() {
        return "redirect:/index";
    }

}
