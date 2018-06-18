package com.rabbitforever.gamblehub.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.services.GambleService;

@Controller
public class GambleController {
    @Autowired
    private GambleService gambleService;
    
    @PostMapping("/saveBigSmall")
    public String saveBigSmallEo(@ModelAttribute("bigSmallEo") @Valid BigSmallEo bigSmallEo,
                            BindingResult result, Model model) {
 
//        if (result.hasErrors()) {
//            model.addAttribute("bigSmallEoList", gambleService.read());
//            return "editUsers";
//        }
 
        gambleService.save(bigSmallEo);
        return "redirect:/";
    }
}
