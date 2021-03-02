package com.diplom.klishin.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Restaurant extends AbstractNamedEntity{

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    protected String contacts;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<Menu> menu;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "vote_id")
    private Vote vote;

    public Restaurant() {
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(min = 2, max = 100) String contacts) {
        this.name = name;
        this.contacts = contacts;
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(min = 2, max = 100) String contacts, Set<Menu> menu, Vote vote) {
        this.name = name;
        this.contacts = contacts;
        this.menu = menu;
        this.vote = vote;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}
