package com.wallouf.usersmanagement.entities;

import java.util.Set;

public class Group {
    private Integer id;
    private String  email;
    private Set     Group;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public Set getGroup() {
        return Group;
    }

    public void setGroup( Set group ) {
        Group = group;
    }

}
