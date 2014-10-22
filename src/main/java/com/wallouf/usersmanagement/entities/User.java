package com.wallouf.usersmanagement.entities;

import java.util.Set;

public class User {

    private Integer id;
    private String  name;

    private Set     Group;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Set getGroup() {
        return Group;
    }

    public void setGroup( Set group ) {
        Group = group;
    }

}
