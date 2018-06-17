package com.rabbitforever.gamblehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rabbitforever.gamblehub.services.UserService;

@Controller
public class GambleController {
    @Autowired
    private UserService userService;
}
