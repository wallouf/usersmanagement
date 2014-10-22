package com.wallouf.usersmanagement.dao;

import java.util.List;

import com.wallouf.usersmanagement.entities.User;

public interface IUserDAO {
    List<User> rechercherUsers();

    User rechercherUser( final String email );

    void creerUser( final User pUser );

    void supprimerUser( final User pUser );
}