package com.wallouf.usersmanagement.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "user" )
public class User {

    private Integer    id;
    private String     name;
    private String     email;
    private Set<Group> groups = new HashSet<Group>( 0 );

    public User() {
        super();
    }

    public User( Integer id, String name, Set<Group> groups ) {
        super();
        this.id = id;
        this.name = name;
        this.groups = groups;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id", unique = true, nullable = false )
    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    @Column( name = "name", unique = false, nullable = false, length = 50 )
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Column( name = "email", unique = true, nullable = false, length = 50 )
    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable( name = "user_has_group", catalog = "sagemcom", joinColumns = {
            @JoinColumn( name = "user_id", nullable = false, updatable = false ) },
            inverseJoinColumns = { @JoinColumn( name = "group_id",
                    nullable = false, updatable = false ) } )
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups( Set<Group> groups ) {
        this.groups = groups;
    }

}
