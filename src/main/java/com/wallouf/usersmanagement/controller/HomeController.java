package com.wallouf.usersmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( "/" )
public class HomeController {

    @RequestMapping( method = RequestMethod.GET )
    public String afficherBonjour( final ModelMap pModel ) {
        return "index";
    }
}