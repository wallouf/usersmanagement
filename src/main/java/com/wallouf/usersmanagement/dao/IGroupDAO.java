package com.wallouf.usersmanagement.dao;

import java.util.List;

import com.wallouf.usersmanagement.entities.Group;

public interface IGroupDAO {
    List<Group> findGroups();

    Group findGroup( final String name );

    void createGroup( final Group pGroup );

    void removeGroup( final Group pGroup );
}