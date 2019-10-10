package com.sda.amisescalade.services;

import com.sda.amisescalade.dao.TopoDAO;
import com.sda.amisescalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopoController {
    @Autowired
    private TopoDAO topoDAO;

    @RequestMapping(value = "/formTopo")
    public String form(Model model){
        model.addAttribute("topo", new Topo());
        return "formTopo";
    }
}
