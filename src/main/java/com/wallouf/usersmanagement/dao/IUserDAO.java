package com.wallouf.usersmanagement.dao;

import java.util.List;

import com.wallouf.usersmanagement.entities.User;

public interface IUserDAO {
    List<User> findUsers();

    User findUser( final String email );

    void createUser( final User pUser );

    void updateUser( final User pUser );

    void removeUser( final User pUser );
}