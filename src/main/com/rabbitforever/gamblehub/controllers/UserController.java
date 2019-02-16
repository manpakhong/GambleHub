package com.rabbitforever.gamblehub.controllers;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rabbitforever.gamblehub.models.eos.UserEo;
import com.rabbitforever.gamblehub.services.UserMgr;

@Controller
public class UserController {
    @Autowired
    private UserMgr userService;
 
    @GetMapping("/userList")
    public String userForm(Locale locale, Model model) {
        model.addAttribute("users", userService.list());
        return "editUser";
    }
     
    @ModelAttribute("user")
    public UserEo formBackingObject() {
        return new UserEo();
    }
 
    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("userEo") @Valid UserEo userEo,
                            BindingResult result, Model model) {
 
        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "editUsers";
        }
 
        userService.save(userEo);
        return "redirect:/";
    }
}
