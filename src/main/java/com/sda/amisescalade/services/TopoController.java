package com.sda.amisescalade.services;

import com.sda.amisescalade.dao.TopoDAO;
import com.sda.amisescalade.entities.Topo;
import com.sda.amisescalade.entities.TopoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TopoController {
    @Autowired
    private TopoDAO topoDAO;

    @RequestMapping(value = "/formTopo")
    public String form(Model model){
        model.addAttribute("topo", new Topo());
        return "formTopo";
    }

    @RequestMapping(value = "/saveFromTopo")
    public String saveFormTopo (Model model, @ModelAttribute("topoForm") @Validated TopoForm topoform, BindingResult result, final RedirectAttributes redirectAttributes) {

        Topo newTopo = new Topo();
        newTopo.setTopoCity(topoform.getTopoCity());
        newTopo.setTopoCountry(topoform.getTopoCountry());
        newTopo.setTopoDepartement(topoform.getTopoDepartement());
        newTopo.setTopoName(topoform.getTopoName());
        newTopo.setRelease(topoform.getRelease());
        newTopo.setAvailable(topoform.isAvailable());

        try{
            topoDAO.save(newTopo);
        }
        catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "fromTopo";
        }
        redirectAttributes.addFlashAttribute("flashTopo", newTopo);
        return "redirect:/";
    }

}
