package com.wallouf.usersmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.wallouf.usersmanagement.entities.Group;

@Repository
public class GroupDAO implements IGroupDAO {
    private static final String HQL_SELECT_PAR_EMAIL = "select c from Group c where c.name=?1";
    private static final String PARAM_EMAIL          = "1";

    @PersistenceContext
    private EntityManager       entityManager;

    public List<Group> findGroups() {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Group> lCriteriaQuery = lCriteriaBuilder.createQuery( Group.class );
        final Root<Group> lRoot = lCriteriaQuery.from( Group.class );
        lCriteriaQuery.select( lRoot );
        final TypedQuery<Group> lTypedQuery = entityManager.createQuery( lCriteriaQuery );

        return lTypedQuery.getResultList();
    }

    public void createGroup( Group pGroup ) {
        entityManager.persist( pGroup );

    }

    public void removeGroup( Group pGroup ) {
        final Group lGroup = entityManager.getReference( Group.class, pGroup.getId() );
        entityManager.remove( lGroup );
    }

    public Group findGroup( String email ) {
        Query requete = entityManager.createQuery( HQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );
        try {
            return (Group) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

}
