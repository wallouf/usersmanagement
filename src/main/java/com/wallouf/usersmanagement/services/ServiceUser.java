package com.wallouf.usersmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallouf.usersmanagement.dao.IUserDAO;
import com.wallouf.usersmanagement.entities.User;

@Service
public class ServiceUser implements IServiceUser {

    @Autowired
    private IUserDAO     dao;
    private List<String> formErrors                 = new ArrayList<String>();

    final private String ERROR_MESSAGE_nameLength   = "User.creation.name.Length";
    final private String ERROR_MESSAGE_nameEmpty    = "User.creation.name.NotEmpty";
    final private String ERROR_MESSAGE_emailLength  = "User.creation.email.Length";
    final private String ERROR_MESSAGE_emailEmpty   = "User.creation.email.NotEmpty";
    final private String ERROR_MESSAGE_emailPattern = "User.creation.email.Pattern";

    private void setFormError( String message ) {
        formErrors.add( message );
    }

    public List<String> getFormErrors() {
        return formErrors;
    }

    @Transactional( readOnly = true )
    public List<User> findUsers() {
        return dao.findUsers();
    }

    @Transactional
    public void createUser( String pName, String pEmail ) {
        resetErrorMaps();

        checkName( pName );
        checkEmail( pEmail );
        if ( getFormErrors().isEmpty() ) {
            if ( this.findUser( pEmail ) != null ) {
                final User lUser = new User();
                lUser.setName( pName );
                lUser.setEmail( pEmail );
                dao.updateUser( lUser );
            } else {
                final User lUser = new User();
                lUser.setName( pName );
                lUser.setEmail( pEmail );
                dao.createUser( lUser );
            }
        }
    }

    @Transactional
    public void removeUser( Integer pIdUser ) {
        final User lUser = new User();
        lUser.setId( pIdUser );
        dao.removeUser( lUser );
    }

    public User findUser( String email ) {
        return dao.findUser( email );
    }

    private void checkName( String pName ) {
        if ( pName == null || pName.trim().length() == 0 ) {
            setFormError( ERROR_MESSAGE_nameEmpty );
        } else if ( pName.trim().length() > 50 ) {
            setFormError( ERROR_MESSAGE_nameLength );
        }
    }

    private void checkEmail( String pEmail ) {
        if ( pEmail == null || pEmail.trim().length() == 0 ) {
            setFormError( ERROR_MESSAGE_emailEmpty );
        } else if ( pEmail.trim().length() > 50 ) {
            setFormError( ERROR_MESSAGE_emailLength );
        } else if ( !pEmail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            setFormError( ERROR_MESSAGE_emailPattern );
        }
    }

    private void resetErrorMaps() {
        formErrors.clear();
    }
}
