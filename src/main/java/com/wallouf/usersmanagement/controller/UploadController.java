package com.wallouf.usersmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( "/upload" )
public class UploadController {

    @RequestMapping( method = RequestMethod.GET )
    public String display( final ModelMap pModel ) {
        return "upload";
    }

    @RequestMapping( method = RequestMethod.POST )
    public String uploadData( final ModelMap pModel, HttpServletRequest request, HttpServletResponse response ) {
        return "upload";
    }
}