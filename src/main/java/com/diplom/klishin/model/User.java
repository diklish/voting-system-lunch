package com.diplom.klishin.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User extends AbstractNamedEntity {

    @NotBlank
    @Size(min = 5, max = 100)
    @Column(name = "password", nullable = false)
    private String password;

    @Email
    @NotBlank
    @Size(max = 100)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "vote_id", nullable = true)
    private Vote vote;

    public User() {
    }


    public User(@NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(min = 5, max = 100) String password, @Email @NotBlank @Size(max = 100) String email, boolean active, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.active = active;
        this.roles = roles;
    }

    public User(@NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(min = 5, max = 100) String password, @Email @NotBlank @Size(max = 100) String email, boolean active, Set<Role> roles, Vote vote) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.active = active;
        this.roles = roles;
        this.vote = vote;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }


}
