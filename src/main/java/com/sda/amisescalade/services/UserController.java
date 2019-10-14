package com.sda.amisescalade.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("espacePerso")
    public String espacePerso() {return "espacePerso";}

    @RequestMapping("/logout")
    public String logout() {
        return "login?logout";
    }


}
