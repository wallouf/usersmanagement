package com.wallouf.usermanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallouf.usersmanagement.dao.IGroupDAO;
import com.wallouf.usersmanagement.entities.Group;

@Service
public class ServiceGroup implements IServiceGroup {

    @Autowired
    private IGroupDAO    dao;
    private List<String> formErrors               = new ArrayList<String>();

    final private String ERROR_MESSAGE_nameLength = "Goup.creation.name.Length";
    final private String ERROR_MESSAGE_nameEmpty  = "Group.creation.name.NotEmpty";

    private void setFormError( String message ) {
        formErrors.add( message );
    }

    public List<String> getFormErrors() {
        return formErrors;
    }

    @Transactional( readOnly = true )
    public List<Group> findGroups() {
        return dao.findGroups();
    }

    @Transactional
    public void createGroup( String pName ) {
        resetErrorMaps();

        checkName( pName );
        if ( getFormErrors().isEmpty() ) {
            if ( this.findGroup( pName ) != null ) {
                final Group lGroup = new Group();
                lGroup.setName( pName );
                dao.updateGroup( lGroup );
            } else {
                final Group lGroup = new Group();
                lGroup.setName( pName );
                dao.createGroup( lGroup );
            }
        }
    }

    @Transactional
    public void removeGroup( Integer pIdGroup ) {
        final Group lGroup = new Group();
        lGroup.setId( pIdGroup );
        dao.removeGroup( lGroup );
    }

    public Group findGroup( String name ) {
        return dao.findGroup( name );
    }

    private void checkName( String pName ) {
        if ( pName == null || pName.trim().length() == 0 ) {
            setFormError( ERROR_MESSAGE_nameEmpty );
        } else if ( pName.trim().length() > 50 ) {
            setFormError( ERROR_MESSAGE_nameLength );
        }
    }

    private void resetErrorMaps() {
        formErrors.clear();
    }
}
