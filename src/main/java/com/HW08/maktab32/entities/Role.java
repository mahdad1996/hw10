package com.HW08.maktab32.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
@JsonIgnoreProperties(value = {"users"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//    @JoinTable(name = "user_role",
//            joinColumns = { @JoinColumn(name = "rid") },
//            inverseJoinColumns = { @JoinColumn(name = "uid") })
//    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role(String title) {
        this.title = title;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }
    @JsonIgnore
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
