package com.wallouf.usersmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wallouf.usersmanagement.entities.Group;
import com.wallouf.usersmanagement.entities.User;
import com.wallouf.usersmanagement.services.IServiceGroup;
import com.wallouf.usersmanagement.services.IServiceUser;

@Controller
@RequestMapping( "/list" )
public class ListController {
    private static final String ATT_listUsers  = "usersList";
    private static final String ATT_listGroups = "groupsList";

    @Autowired
    private IServiceUser        serviceUser;
    @Autowired
    private IServiceGroup       serviceGroup;

    @RequestMapping( method = RequestMethod.GET )
    public String display( final ModelMap pModel, HttpServletRequest request, HttpServletResponse response ) {
        List<User> listU = serviceUser.findUsers();
        List<Group> listG = serviceGroup.findGroups();
        HttpSession session = request.getSession();
        session.setAttribute( ATT_listUsers, listU );
        session.setAttribute( ATT_listGroups, listG );
        return "list";
    }
}