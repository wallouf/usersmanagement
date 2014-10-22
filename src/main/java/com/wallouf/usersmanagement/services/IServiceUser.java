package com.wallouf.usersmanagement.services;

import java.util.List;

import com.wallouf.usersmanagement.entities.User;

public interface IServiceUser {
    List<User> findUsers();

    User findUser( final String email );

    void createUser( final String pName, final String pEmail );

    void removeUser( final Integer pIdUser );
}
