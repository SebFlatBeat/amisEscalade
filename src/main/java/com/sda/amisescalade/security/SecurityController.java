package com.sda.amisescalade.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    //@RequestMapping(value = "/login")
    public String login(){
        return "index";
    }
}
