package com.wallouf.usersmanagement.services;

import java.util.List;

import com.wallouf.usersmanagement.entities.Group;

public interface IServiceGroup {
    List<Group> findGroups();

    Group findGroup( final String name );

    void createGroup( final String name );

    void removeGroup( final Integer pIdGroup );
}
